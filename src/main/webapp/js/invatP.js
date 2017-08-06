
function listInvatP(listaPartialaJson) {
    var list1 = document.getElementById('listDeInvatatP');
    var listHtml = '';

    for (var i = 0; i < listaPartialaJson.length; i++) {
        var lPartiala = listaPartialaJson[i];
        listHtml = listHtml + lPartiala.continent + '</br>';
    }
    list1.innerHTML = listHtml;}

function listDeInvatatP() {
    $.ajax({
        url: 'invatpurl?action=list'
    }).done(function (response) {
        listInvatP(response.listaPartialaJson);
    })
}