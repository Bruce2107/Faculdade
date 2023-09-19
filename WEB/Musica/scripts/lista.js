let albuns = [];
window.onload = () => {
  albuns = JSON.parse(localStorage.getItem('albuns')) || [];
  document.getElementById(
    'count'
  ).innerHTML = `Quantidade de discos exibidos: ${albuns.length}`;
  populateCards();
  if (albuns.length <= 5) {
    document.getElementById('pagination').style.display = 'none';
  }
};

function populateCards() {
  let article = document.getElementById('article');
  albuns.forEach((album) => {
    let card = `
      <div class="card">
        <a href="Musica/disco.html" onClick="manageRoute(${album.id})">
          <figure>
            <img src="./assests/${album.cover}" alt="Capa do album ${
      album.name
    }" width="64px">
            <figcaption>${album.name}</figcaption>
          </figure>
          <p>${album.autores.join(', ')}</p>
        </a>
         <div class="buttons">
          <button type="button">Favoritar</button>
          <button type="button" onClick="removeAlbum(${
            album.id
          })">Remover</button>
        </div>
      </div>
    `;
    article.innerHTML += card;
  });
}
function removeAlbum(id) {
  let albums = albuns.filter((album) => album.id !== id);
  localStorage.setItem('albuns', JSON.stringify(albums));
  window.location.reload();
}

function manageRoute(id) {
  let album = albuns.find((album) => album.id === id);
  localStorage.setItem('route', JSON.stringify(album));
}
