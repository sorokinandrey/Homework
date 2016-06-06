$(function () {
    $.get("/data", {action: "getData"})
        .done(function (data) {
            console.log(data);
            window.data = data;
            var header = data["restaurants_header"];
            var headerArray = mappingToArray(header);
            var excluded = ["Дом", "Округ", "Город", "Улица", "Адрес", "Ближайшая линия метро", "Метро (широта)",
                "Метро (долгота)", "Доступно для людей с ограниченными возможностями"];
            var excludedIndices = [];
            for (var i = excluded.length; i >= 0; i--) {
                excludedIndices.push(header[excluded[i]]);
            }
            drawTable("#restaurants", data["restaurants"], excludedIndices, headerArray);
            $('#restaurants').dataTable( {
                language: {
                    url: '/js/lib/DataTables/Russian.json'
                }
            } );
            putMarkers(data);
        });

    function drawTable(id, rows, excludedIndices, headerArray) {
        var thead = $("<thead />");
        var tbody = $("<tbody />");
        drawHeader(thead, excludedIndices, headerArray);
        $(id).append(thead);
        for (var i = 0; i < rows.length; i++) {
            drawRow(tbody, rows[i], excludedIndices, headerArray);
        }
        $(id).append(tbody);
    }

    function drawHeader(elem, excludedIndices, headerArray) {
        var header = $("<tr />");
        elem.append(header);
        for (var i = 0; i < headerArray.length; i++) {
            if (excludedIndices.indexOf(i) == -1) {
                header.append($("<th>" + headerArray[i] + "</th>"));
            }
        }
    }

    function mappingToArray(mapping) {
        var invertedMapping = [];
        for (var key in mapping) {
            if (mapping.hasOwnProperty(key)) {
                invertedMapping[mapping[key]] = key;
            }
        }
        return invertedMapping;
    }

    function drawRow(elem, rowData, excludedIndices, headerArray) {
        var row = $("<tr />");
        elem.append(row);
        for (var j = 0; j < rowData.length; j++) {
            if (excludedIndices.indexOf(j) == -1) {
                var td = $("<td>" + rowData[j] + "</td>");
                if (headerArray[j] === "Район") {
                    var districtInfo = makeDistrictInfo(rowData[j]);
                    td.html(districtInfo);
                }
                row.append(td);
            }
        }
    }

    function makeDistrictInfo(name) {
        var info = $("<a />");
        info.html(name);
        info.attr("title", name);
        info.hover(function () {
            el = $(this);
            $.get("/data", {action: "getDistrictData", district: name})
                .done(function (d) {
                    el.unbind('hover').popover({
                        content: "Код района: " + d["code"] + "; Код ОКАТО: " + d["okato"],
                        title: 'Dynamic response!',
                        html: true,
                        delay: {show: 500, hide: 100}
                    }).popover('show');
                });
        }, function () {
            el = $(this);
            el.popover('hide');
        });
        return info;
    }

    function putMarkers(data) {
        var restaurants = data["restaurants"];
        var map = new google.maps.Map(document.getElementById('map'), {
            zoom: 12,
            center: new google.maps.LatLng(59.9531087, 30.2975372),
            mapTypeId: google.maps.MapTypeId.ROADMAP
        });

        var infowindow = new google.maps.InfoWindow;

        var marker;

        for (var i = 0; i < restaurants.length; i++) {
            marker = new google.maps.Marker({
                position: new google.maps.LatLng(restaurants[i][20], restaurants[i][21]),
                map: map
            });

            google.maps.event.addListener(marker, 'click', (function (marker, i) {
                return function () {
                    infowindow.setContent(restaurants[i][0] + " " + restaurants[i][1]);
                    infowindow.open(map, marker);
                }
            })(marker, i));
            google.maps.event.trigger(map, 'resize');
        }
    }
});
