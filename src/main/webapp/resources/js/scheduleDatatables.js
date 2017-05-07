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
    oMyForm.append("file", file2.files[0]);
    $.ajax({
        url: 'ajax/admin/schedules/file',
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

$(document).ready(function () {
    $("#btnSubmit").click(function (event) {
        //stop submit the form, we will post it manually.
        event.preventDefault();
        fire_ajax_submit();
    });
});

function fire_ajax_submit() {
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    data.append("CustomField", "This is some extra data, testing");
    $("#btnSubmit").prop("disabled", true);
    $.ajax({
        type: "POST",
        enctype: 'multipart/form-data',
        url: "/ajax/admin/schedules/file",
        data: data,
        //http://api.jquery.com/jQuery.ajax/
        //https://developer.mozilla.org/en-US/docs/Web/API/FormData/Using_FormData_Objects
        processData: false, //prevent jQuery from automatically transforming the data into a query string
        contentType: false,
        cache: false,
        timeout: 600000,
        success: function (data) {
            successNoty('common.saved');
        }
    });

}

