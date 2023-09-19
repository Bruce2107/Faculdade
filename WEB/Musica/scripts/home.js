const albuns = [
  {
    id: 1,
    name: 'Nina Simone at town hall',
    cover: 'cover_nina_simone.jpg',
    autores: ['Nina Simone'],
    route: 'nina_simone_at_town_hall.html',
    generos: ['Jazz', 'Pop'],
    ano: 1959,
    gravadora: 'Colpix Records',
    faixas: [
      { name: "Black Is The Color Of My True Love's Hair", duration: '3:23' },
      { name: 'Exactly Like You', duration: '3:06' },
      { name: 'The Other Woman', duration: '2:52' },
      { name: 'Under The Lowest', duration: '5:18' },
      { name: 'You Can Have Him', duration: '5:43' },
      { name: 'Summertime (Instrumental)', duration: '2:49' },
      { name: 'Summertime (Vocal)', duration: '2:39' },
      { name: 'Cotton Eyed Joe', duration: '2:51' },
      { name: 'Return Home', duration: '4:55' },
      { name: 'Wild Is The Wind', duration: '3:22' },
      { name: 'Fine And Mellow', duration: '3:18' },
    ],
  },
  {
    id: 2,
    name: 'Televisão',
    cover: 'titas_televisao.jpg',
    autores: ['Titãs'],
    route: 'titas_televisao.html',
    generos: ['Rock', 'Pop'],
    ano: 1985,
    gravadora: 'WEA',
    faixas: [
      { name: 'Televisão', duration: '3:40' },
      { name: 'Insensível', duration: '4:25' },
      { name: 'Pavimentação', duration: '2:25' },
      { name: 'Dona Nenê', duration: '3:35' },
      { name: 'Pra Dizer Adeus', duration: '5:00' },
      { name: 'Não Vou Me Adaptar', duration: '2:45' },
      { name: 'Tudo Vai Passar', duration: '3:40' },
      { name: 'Sonho Com Você', duration: '3:05' },
      { name: 'O Homem Cinza', duration: '3:40' },
      { name: 'Autonomia', duration: '2:55' },
      { name: 'Massacre', duration: '1:40' },
    ],
  },
  {
    id: 3,
    name: 'O tempo não para',
    cover: 'cazuza_o_tempo_nao_para.jpg',
    autores: ['Cazuza'],
    route: 'cazuza_o_tempo_nao_para.html',
    generos: ['Rock', 'Pop'],
    gravadora: 'Philips',
    ano: 1988,
    faixas: [
      { name: 'A1	Vida Louca Vida', duration: '4:19' },
      { name: 'A2	Boas Novas', duration: '2:46' },
      { name: 'A3	Ideologia', duration: '4:12' },
      { name: 'A4	Todo Amor Que Houver Nessa Vida', duration: '2:49' },
      { name: 'A5	Codinome Beija-Flôr', duration: '2:55' },
      { name: 'B1	O Tempo Não Pára', duration: '4:50' },
      { name: 'B2	Só As Mães São Felizes', duration: '3:45' },
      { name: 'B3	O Nosso Amor A Gente Inventa', duration: '3:35' },
      { name: 'B4	Exagerado', duration: '4:38' },
      { name: 'B5	Faz Parte Do Meu Show', duration: '3:48' },
    ],
  },
  {
    id: 4,
    name: 'Out of time',
    cover: 'rem_out_of_time.jpg',
    autores: ['R.E.M.'],
    route: 'rem_out_of_time.html',
    generos: ['Alternative Rock', 'Pop Rock'],
    ano: 1991,
    faixas: [
      { name: 'Radio Song', duration: '4:12' },
      { name: 'Losing My Religion', duration: '4:26' },
      { name: 'Low', duration: '4:55' },
      { name: 'Near Wild Heaven', duration: '3:17' },
      { name: 'Endgame', duration: '3:48' },
      { name: 'Shiny Happy People', duration: '3:44' },
      { name: 'Belong', duration: '4:03' },
      { name: 'Half A World Away', duration: '3:26' },
      { name: 'Texarkana', duration: '3:36' },
      { name: 'Country Feedback', duration: '4:07' },
      { name: 'Me In Honey', duration: '4:06' },
    ],
  },
  {
    id: 5,
    name: 'Полное Собрание Романсов',
    cover: 'Polnoye_Sobraniye_Romansov.jpg',
    autores: ['Sergei Vasilyevich Rachmaninoff'],
    route: 'Polnoye_Sobraniye_Romansov.html',
    generos: ['Classica'],
    gravadora: '	Мелодия',
    ano: 1976,
    faixas: [
      { name: 'A1		У Врат Обители Святой', duration: '-' },
      { name: 'A2		Я Тебе Ничего Не Скажу', duration: '-' },
      { name: 'A3		Опять Встрепенулось Ты, Сердце', duration: '-' },
      { name: 'A4		Апрель! Вешний Праздничный День', duration: '-' },
      { name: 'A5		Смеркалось', duration: '-' },
      { name: 'A6		Песня Разочарованного', duration: '-' },
      { name: 'A7		Увял Цветок', duration: '-' },
      { name: 'A8		Ты Помнишь Ли Вечер', duration: '-' },
      { name: 'B1		Икалось Ли Тебе', duration: '-' },
      { name: 'B2		О Нет, Молю, Не Уходи!', duration: '-' },
      { name: 'B3		Утро', duration: '-' },
      { name: 'B4		В Молчаньи Ночи Тайной', duration: '-' },
      { name: 'B5		Не Пой, Красавица', duration: '-' },
      { name: 'B6		Уж Ты, Нива Моя', duration: '-' },
      { name: 'B7		Давно Ль, Мой Друг', duration: '-' },
      { name: 'B8		Речная Лилея', duration: '-' },
      { name: 'C1		Дитя! Как Цветок, Ты Прекрасна', duration: '-' },
      { name: 'C2		Дума', duration: '-' },
      { name: 'C3		Полюбила Я На Печаль Свою', duration: '-' },
      { name: 'C4		Сон', duration: '-' },
      { name: 'C5		Молитва', duration: '-' },
      { name: 'C6		Я Жду Тебя', duration: '-' },
      { name: 'C7		Островок', duration: '-' },
      { name: 'C8		Давно В Любви', duration: '-' },
      { name: 'C9		Я Был У Ней', duration: '-' },
      { name: 'D1		Эти Летние Ночи', duration: '-' },
      { name: 'D2		Тебя Так Любят Все', duration: '-' },
      { name: 'D3		Не Верь Мне, Друг!', duration: '-' },
      { name: 'D4		О, Не Грусти!', duration: '-' },
      { name: 'D5		Она, Как Полдень, Хороша', duration: '-' },
      { name: 'D6		В Моей Душе', duration: '-' },
      { name: 'D7		Весенние Воды', duration: '-' },
      { name: 'D8		Пора!', duration: '-' },
      { name: 'E1		Судьба', duration: '-' },
      { name: 'E2		Над Свежей Могилой', duration: '-' },
      { name: 'E3		Сумерки', duration: '-' },
      { name: 'E4		Они Встречали', duration: '-' },
      { name: 'E5		Сирень', duration: '-' },
      { name: 'E6		Отрывок Из Мюссе', duration: '-' },
      { name: 'E7		Здесь Хорошо', duration: '-' },
      { name: 'E8		На Смерть Чижика', duration: '-' },
      { name: 'F1		Мелодия', duration: '-' },
      { name: 'F2		Пред Иконой', duration: '-' },
      { name: 'F3		Я Не Пророк', duration: '-' },
      { name: 'F4		Как Мне Больно', duration: '-' },
      { name: 'F5		Ночь', duration: '-' },
      { name: 'F6		Есть Много Звуков', duration: '-' },
      { name: 'F7		Все Отнял У Меня', duration: '-' },
      { name: 'F8		Мы Отдохнем', duration: '-' },
      { name: 'G1		Два Прощания', duration: '-' },
      { name: 'G2		Покинем, Милая', duration: '-' },
      { name: 'G3		Христос Воскрес!', duration: '-' },
      { name: 'G4		К Детям', duration: '-' },
      { name: 'G5		Пощады Я Молю!', duration: '-' },
      { name: 'G6		Я Опять Одинок', duration: '-' },
      { name: 'G7		У Моего Окна', duration: '-' },
      { name: 'G8		Фонтан', duration: '-' },
      { name: 'G9		Ночь Печальна', duration: '-' },
      { name: 'H1		Вчера Мы Встретились', duration: '-' },
      { name: 'H2		Кольцо', duration: '-' },
      { name: 'H3		Проходит Все', duration: '-' },
      { name: 'H4		Письмо К. С. Станиславкому От Рахманинова', duration: '-' },
      { name: 'H5		Муза', duration: '-' },
      { name: 'H6		В Душе У Каждого Из Нас', duration: '-' },
      { name: 'H7		Буря', duration: '-' },
      { name: 'H8		Ветер Перелетный', duration: '-' },
      { name: 'H9		Арион', duration: '-' },
      { name: 'I1		Воскрешение Лазаря', duration: '-' },
      { name: 'I2		Не Может Быть!', duration: '-' },
      { name: 'I3		Музыка', duration: '-' },
      { name: 'I4		Ты Знал Его', duration: '-' },
      { name: 'I5		Сей День Я Помню', duration: '-' },
      { name: 'I6		Оброчник', duration: '-' },
      { name: 'I7		Какое Счастье', duration: '-' },
      { name: 'I8		Диссонанс', duration: '-' },
      { name: 'J1		Вокализ', duration: '-' },
      { name: 'J2		Из Евангелия От Иоанна', duration: '-' },
      { name: 'J3		Ночью В Саду У Меня', duration: '-' },
      { name: 'J4		К Ней', duration: '-' },
      { name: 'J5		Маргаритки', duration: '-' },
      { name: 'J6		Крысолов', duration: '-' },
      { name: 'J7		Сон', duration: '-' },
      { name: 'J8		Ау!', duration: '-' },
    ],
  },
];

window.onload = () => {
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
        <a href="disco.html" onClick="manageRoute(${album.id})">
          <figure>
            <img src="./assests/${album.cover}" alt="Capa do album ${
      album.name
    }" width="64px">
            <figcaption>${album.name}</figcaption>
          </figure>
          <p>${album.autores.join(', ')}</p>
        </a>
        <button type="button" onClick="addAlbum(${album.id})">Adicionar</button>
      </div>
    `;
    article.innerHTML += card;
  });
}

function addAlbum(id) {
  let album = albuns.find((album) => album.id === id);
  let lSAlbuns = JSON.parse(localStorage.getItem('albuns')) || [];
  if (typeof lSAlbuns === typeof []) {
    lSAlbuns = [...lSAlbuns];
  }
  if (lSAlbuns.find((album) => album.id === id)) {
    alert('Album já adicionado!');
    return;
  }
  lSAlbuns.push(album);
  localStorage.setItem('albuns', JSON.stringify(lSAlbuns));
  alert('Album adicionado com sucesso!');
}

function manageRoute(id) {
  let album = albuns.find((album) => album.id === id);
  localStorage.setItem('route', JSON.stringify(album));
}
