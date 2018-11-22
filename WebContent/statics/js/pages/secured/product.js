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
                    if (response.status = "success") {
                        response = JSON.parse(resp);
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
        }
    })

    $(document).on('click', '.fa-file', function () {
        var id = this.id;
        $.ajax({
            type: "GET",
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            url: webContextPath + "/secured/user/product/file/get?id="+id,
        }).done(function (resp, status, jqXHR) {
            if (resp != undefined && resp.status == undefined) {
                var response = JSON.parse(resp);
                if (response.status = "success") {
                    response = JSON.parse(resp);
                    var blob = new Blob([response.data.fileData]);
                    var link = document.createElement('a');
                   // Browsers that support HTML5 download attribute
                    if (link.download !== undefined) {
                        url = URL.createObjectURL(blob);
                        var fileName = response.data.fileName;
                        link.setAttribute('href', url);
                        link.setAttribute('download', fileName);
                        link.style.visibility = 'hidden';
                        document.body.appendChild(link);
                        link.click();
                        document.body.removeChild(link);
                    }
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