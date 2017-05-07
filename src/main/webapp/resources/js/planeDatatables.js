var ajaxUrl = 'ajax/admin/planes/';
var datatableApi;
var editTitleKey ="planes.edit";

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

// $(document).ready(function () {
$(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "name"
            },
            {
                "data": "type"
            },
            {
                "data": "seatEconom"
            },
            {
                "data": "seatBusiness"
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderEditBtn
            },
            {
                "orderable": false,
                "defaultContent": "",
                "render": renderDeleteBtn
            }
        ],
        "order": [
            [
                1,
                "asc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {}
    }));
});