var ajaxUrl = 'ajax/admin/schedules/';
var datatableApi;
var editTitleKey ="schedules.edit";

function updateTable() {
    $.get(ajaxUrl, updateTableByData);
}

// $(document).ready(function () {
$(function () {
    datatableApi = $('#datatable').DataTable(extendsOpts({
        "columns": [
            {
                "data": "date",
                "render": function (date, type, row) {
                    if (type == 'display') {
                        return date.replace('T', ' ').substr(0, 16);
                    }
                    return date;
                }
            },
            {
                "data": "number"
            },
            {
                "data": "regionDate",
                "render": function (date, type, row) {
                    if (type == 'display') {
                        return date.replace('T', ' ').substr(0, 16);
                    }
                    return date;
                }
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
                0,
                "desc"
            ]
        ],
        "createdRow": function (row, data, dataIndex) {}
    }));
});

function uploadFormData(){
    var oMyForm = new FormData();
    oMyForm.append("file", file.files[0]);
    $.ajax({
        url: ajaxUrl+'file',
        data: oMyForm,
        dataType: 'text',
        processData: false,
        contentType: false,
        type: 'POST',
        success: function(data){
            successNoty('common.saved');
        }
    });
}
