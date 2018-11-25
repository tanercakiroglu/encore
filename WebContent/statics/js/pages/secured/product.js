$(document).ready(function () {
    var table = $('#products').DataTable({
        responsive: true,
        language: {
            lengthMenu: "Sayfada _MENU_ Göster",
            zeroRecords: "Kayıt Bulunmamaktadır.",
            info: "Sayfa _PAGE_ Gösterliyor.  ",
            infoEmpty: "Kayıt Bulunmamaktadır.",
            infoFiltered: "(filtered from _MAX_ total records)"
        }
    });


    $(function () {
        $('#productForm').validate({
            rules: {
                productName: {
                    required: true
                },
                productType: {
                    valueEquals: "Seçiniz"
                },
                productOwner: {
                    required: true
                },
                productHeight: {
                    required: true
                },
                productWeight: {
                    required: true
                },
                productDepth: {
                    required: true
                },
                productBuyPrice: {
                    required: true,
                    decimalFormat: true

                },
                productSellPrice: {
                    required: true,
                    decimalFormat: true
                },
                productSupplier: {
                    required: true
                }
            },
            messages: {
                productName: {
                    required: "Ürün adı alanı zorunludur."
                },
                productType: {
                    valueEquals: "Ürün tipi alanı zorunludur."
                },
                productOwner: {
                    required: "Ürün sorumlusu alanı zorunludur "
                },
                productHeight: {
                    required: "Ürün boyu alanı zorunludur ve numerik olması gerekir."
                },
                productWeight: {
                    required: "Ürün eni alanı zorunludur ve numeric olması gerekir."
                },
                productDepth: {
                    required: "Ürün yüksekliği alanı zorunludur  ve numeric olması gerekir."
                },
                productBuyPrice: {
                    required: "Alış fiyatı alanı zorunludur ve 1221.23 formatında olmalıdır.",
                    decimalFormat: "Tutar girişleri 1221.23 formatında olmalıdır."
                },
                productSellPrice: {
                    required: "Satış fiyatı alanı zorunludur ve 1221.23 formatında olmalıdır.",
                    decimalFormat: "Tutar girişleri 1221.23 formatında olmalıdır."
                },
                productSupplier: {
                    required: "Ürün tedarikcisi alanı zorunludur."
                }
            },
            errorPlacement: function (error, element) {

                element.attr('data-original-title', error.text());
                $(".error").tooltip(
                    {
                        tooltipClass: "ttError"
                    });
            },
            submitHandler: function (form) {
                var request = {
                    "id": form.id.value,
                    "productName": form.productName.value,
                    "productType": form.productType.value,
                    "productOwner": form.productOwner.value,
                    "productHeight": form.productHeight.value,
                    "productWeight": form.productWeight.value,
                    "productDepth": form.productDepth.value,
                    "productBuyPrice": form.productBuyPrice.value,
                    "productSellPrice": form.productSellPrice.value,
                    "productSupplier": form.productSupplier.value
                };

                $.ajax({
                    type: "POST",
                    data: JSON.stringify(request),
                    dataType: 'json',
                    url: form.baseURI + "/add",
                    contentType: "application/json; charset=utf-8",
                }).done(function (resp, status, jqXHR) {
                    if (resp != undefined && resp.status == undefined) {
                        var response = JSON.parse(resp);
                        if (response.status = "success") {
                            bindTable(response.data);
                            clearForm();
                            openModal(response.message);
                        }
                    }
                    if (resp.status == "business_error") {
                        openModal(resp.message);
                    }
                }).fail(function (resp, status, err) {
                    var response;
                    if (resp.status === 400) {
                        response = JSON.parse(resp.responseJSON);
                    } else {
                        response = JSON.parse(resp.responseText);
                    }
                    openModal(response.message);
                })
            }
        });
    })

    $(document).on('click', '.confirmDelete', function () {
        closeDeleteConfirmModal();
        var id=$("#confirmDelete").attr("data-id");
        $.ajax({
            type: "POST",
            data: id,
            dataType: 'json',
            url: webContextPath + "/secured/user/product/remove?id="+id,
            contentType: "application/json; charset=utf-8"
        }).done(function (resp, status, jqXHR) {
            if (resp != undefined && resp.status == undefined) {
                var response = JSON.parse(resp);
                if (response.status = "success") {
                    bindTable(response.data);
                    openModal(response.message);
                    clearForm();
                }
            } else if (resp.status == "business_error") {
                openModal(resp.message);
            }

        }).fail(function (resp, status, err) {
            var response;
            if (resp.status === 400) {
                response = JSON.parse(resp.responseJSON);
            } else {
                response = JSON.parse(resp.responseText);
            }
            openModal(response.message);
        })
    })

    $(document).on('click', '.fa-edit', function () {
        var data;
        if($(this).parents('tr').attr("class")=="child"){
            data = table.row($(this)).data();
        }else{
            data = table.row($(this).parents('tr')).data();
        }
        var keys = Object.keys(data);

        $("#id").val(data[keys[0]]);
        $("#productName").val(data[keys[1]]);
        $("#productSupplier").val(data[keys[2]]);
        if ($.isNumeric(data[keys[3]]))
            $("#productType").val(data[keys[3]]);
        else
            $("#productType option:contains(" + data[keys[3]] + ")").attr('selected', 'selected');
        $('#productHeight').val(data[keys[4]]);
        $("#productWeight").val(data[keys[5]]);
        $("#productDepth").val(data[keys[6]]);
        $("#productOwner").val(data[keys[7]]);
        $("#productBuyPrice").val(data[keys[8]]);
        $("#productSellPrice").val(data[keys[9]]);
    })



    function bindTable(data) {
        table.destroy();
        table = $('#products').DataTable({
            responsive: true,
            searching: true,
            paging: true,
            bInfo: false,
            language: 'tr',
            lengthMenu: [[10, 25, 50, -1], [10, 25, 50, "All"]],
            data: data,
            language: {
                lengthMenu: "Sayfada _MENU_ Göster",
                zeroRecords: "Kayıt Bulunmamaktadır.",
                info: "Sayfa _PAGE_ Gösterliyor.  ",
                infoEmpty: "Kayıt Bulunmamaktadır.",
                infoFiltered: "(filtered from _MAX_ total records)"
            },
            aoColumns: [
                {'mData': "id"},
                {'mData': "productName"},
                {'mData': "productSupplier"},
                {
                    'mRender': function (data, type, row) {
                        return $("#productType option[value=" + (row.productType) + "]").text();
                    }
                },
                {'mData': "productHeight"},
                {'mData': "productWeight"},
                {'mData': "productDepth"},
                {'mData': "productOwner"},
                {'mData': "productBuyPrice"},
                {'mData': "productSellPrice"},
                {
                    'mRender': function (data, type, row) {
                        return '<i id="' + row.id + '"class="fa fa-edit fa-2x"></i>';
                    }
                },
                {
                    'mRender': function (data, type, row) {
                        return '<i id="' + row.id + '"class="fa fa-remove fa-2x"></i>';
                    }
                },
                {
                    'mRender': function (data, type, row) {
                        return '<i id="' + row.fileId + '"class="fa fa-file fa-2x"></i>';
                    }
                }
            ]
        });
    }


    $(document).on('click', '#clear_btn', function () {
        clearForm();
    })

    function clearForm() {
        $(':input', '#productForm')
            .not(':button, :submit, :reset, :hidden')
            .val('')
            .prop('checked', false);

        $("#productType").val($("#productType option:first").val());
    }


    /*  upload file  */

    var form = $('#file-form');
    var fileSelect = $('#file-select');
    var uploadButton = $('#upload-button');

    $(document).on('click', uploadButton, function () {

        var id = this.activeElement.id;
        if (id === "upload-button") {
            uploadButton.text("Uploading");
            var files = fileSelect[0];

            var formData = new FormData();


            // Loop through each of the selected files.
            for (var i = 0; i < files.files.length; i++) {
                var file = files.files[i];
                formData.append(file.name, file, file.name);
            }

            $.ajax({
                data: formData,
                dataType: 'text',
                processData: false,
                contentType: false,
                type: 'POST',
                url: webContextPath + "/secured/user/product/file/add",
            }).done(function (resp, status, jqXHR) {
                if (resp != undefined && resp.status == undefined) {
                    var response = JSON.parse(resp);
                    response = JSON.parse(response);
                    if (response.status = "success") {
                        openModal(response.message);
                    }
                } else if (resp.status == "business_error") {
                    openModal(resp.message);
                }
            }).fail(function (resp, status, err) {
                var response;
                if (resp.status === 400) {
                    response = JSON.parse(resp.responseJSON);
                } else {
                    response = JSON.parse(resp.responseText);
                }
                openModal(response.message);
            })
            uploadButton.text("Upload");
        }
    })

    $(document).on('click', '.fa-file', function () {
        var id = this.id;
        $.ajax({
            type: "GET",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            url: webContextPath + "/secured/user/product/file/get?id=" + id,
        }).done(function (resp, status, jqXHR) {
            if (resp != undefined && resp.status == undefined) {
                var response = JSON.parse(resp);
                if (response.status = "success") {
                    response = JSON.parse(resp);
                    openDocument(response.data.fileData, response.data.fileName);
                }
            } else if (resp.status == "business_error") {
                openModal(resp.message);
            }
        }).fail(function (resp, status, err) {
            var response;
            if (resp.status === 400) {
                response = JSON.parse(resp.responseJSON);
            } else {
                response = JSON.parse(resp.responseText);
            }
            openModal(response.message);
        })
    })
})