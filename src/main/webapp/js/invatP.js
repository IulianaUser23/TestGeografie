
function listInvatP(listaPartialaJson) {
    var list1 = document.getElementById('listDeInvatatP');
    var listHtml = '';

    for (var i = 0; i < listaPartialaJson.length; i++) {
        var lPartiala = listaPartialaJson[i];
        listHtml = listHtml + lPartiala.numeTara + '&nbsp;' + lPartiala.capitala + '</br>';
    }
    list1.innerHTML = listHtml;}

function listDeInvatatP(continent) {
    $.ajax({
        url: 'invatpurl?continent='+continent
    }).done(function (response) {
        listInvatP(response.listaPartialaJson); })
}


