window.onload = () => {
  document
    .getElementById('formCadastro')
    .addEventListener('submit', (e) => validaCampos(e));

  document.getElementById('cover').addEventListener('change', () => {
    let fileName = document.getElementById('cover').files[0].name;
    document.getElementById('file_name').innerHTML = fileName;
  });
};

function validaCampos(e) {
  e.preventDefault();
  let modal = document.getElementById('modal');
  let modalData = document.getElementById('modal_data');
  let albumNome = document.getElementById('album_nome').value;
  let autores = document.getElementById('autores').value;
  let ano = document.getElementById('ano').value;
  let genero = document.getElementById('genero').value;
  let file = document.getElementById('cover').files;
  let faixas = document.getElementById('faixas').value;
  let spotify = document.getElementById('spotify_link').value;

  if (albumNome == '')
    return alert('O campo Nome do Álbum é obrigatório, por favor preencha-o!');
  if (autores == '')
    return alert('O campo Autores é obrigatório, por favor preencha-o!');
  if (ano == '')
    return alert('O campo Ano é obrigatório, por favor preencha-o!');
  if (genero == '')
    return alert('O campo Gênero é obrigatório, por favor preencha-o!');
  if (file == '')
    return alert('O campo Capa é obrigatório, por favor preencha-o!');
  if (faixas == '')
    return alert('O campo Faixas é obrigatório, por favor preencha-o!');
  if (spotify == '')
    return alert('O campo Spotify é obrigatório, por favor preencha-o!');
  let listaAutores = autores.split(';');
  let listaGeneros = genero.split(';');
  let listaFaixas = faixas.split(';');

  console.log({
    albumNome,
    listaAutores,
    ano,
    listaGeneros,
    file,
    listaFaixas,
    spotify,
  });
  document.getElementById('formCadastro').reset();
  return alert('Sucesso');
}
