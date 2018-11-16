$(document).ready(function () {
    var table = $('#proposals').DataTable( {
        responsive: true
    } );
    new $.fn.dataTable.FixedHeader( table );

    var editIcons= $('.fa-edit')

    editIcons.click(function () {
        var id =this.id;
        window.location.href=ctx + "/app/secured/user/proposal/operations?proposalId=" +id;
    })

});
