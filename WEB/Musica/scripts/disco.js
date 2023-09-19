let album = {};
window.onload = () => {
  album = JSON.parse(localStorage.getItem('route')) || {};
  populatePage();
};

function populatePage() {
  let figure = document.getElementsByTagName('figure')[0];
  let figcontent = `
    <img src="./assests/${album.cover}" alt="Capa do album ${album.name}" width="64px">
    <figcaption>${album.name}</figcaption>
  `;
  figure.innerHTML = figcontent;
  let info = document.getElementsByClassName('info')[0];
  let infocontent = `
    <span class="data"><b>Artistas:</b> ${album.autores.join(',')}</span>
    <span class="data"><b>Gêneros:</b> ${album.generos.join(',')}</span>
    <span class="data"><b>Ano de lançamento:</b> ${album.ano}</span>
    <span class="data"><b>Gravadora:</b> ${album?.gravadora || '-'}</span>
    <span class="data"><b>Quantidade de faixas:</b> ${
      album.faixas.length
    }</span>
  `;
  info.innerHTML = infocontent;

  let tbody = document.getElementsByTagName('tbody')[0];
  let tbodycontent = '';
  for (let i = 0; i < album.faixas.length; i++) {
    tbodycontent += `
      <tr>
         <td>${album.faixas[i].name}</td>
         <td>${album.faixas[i].duration}</td>
      </tr>
    `;
  }
  tbody.innerHTML = tbodycontent;
}
