// document.addEventListener("DOMContentLoaded", function (event) {
class LikeButton {
  static create() {
    const likeButton = document.createElement("button");
    likeButton.setAttribute("class", "likeButton");
    likeButton.textContent = "Like";
    return likeButton;
  }
}

const API_URL = "";

const CLIENT_HEIGHT = window.screen.availHeight;

var ms_cols = Array.from(document.querySelectorAll(".col"));

var sheet = window.document.styleSheets[0];

var init_tile = 3;

sheet.insertRule(
  `.col{flex:${(1 / ms_cols.length) * 0.9}`,
  sheet.cssRules.length
);

var image_heights = [
  120,
  130,
  140,
  150,
  160,
  170,
  180,
  190,
  200,
  210,
  220,
  230,
  240,
  250,
  260,
  270,
  280,
  290,
  300,
  310,
  320,
  330,
  340,
  350,
  360,
];

function loadTiles(qual) {
  for (let i = 0; i < qual * ms_cols.length; i++) {
    let tile_height =
      image_heights[Math.floor(Math.random() * image_heights.length)];

    const tile = document.createElement("figure");
    tile.setAttribute("class", "tile");

    const thumbnail = document.createElement("div");
    thumbnail.setAttribute("class", "thumbnail");
    const rand = Math.floor(Math.random() * 256);
    thumbnail.style.backgroundColor = `rgb(${rand}, ${128}, ${256 - rand})`;

    const img = new Image();
    const caption = document.createElement("figcaption");

    img.style.display = "none";

    img.addEventListener("load", () => {
      thumbnail.style.height = img.naturalHeight + "px"; // img.height
      if (img.height > CLIENT_HEIGHT) shinkImageToScreenSize(thumbnail);
      img.height = img.naturalHeight;
      img.width = img.naturalWidth;
      const current_col = getMinHeightCol(ms_cols);
      current_col.appendChild(tile);
      current_col.style.height = current_col.scrollHeight;
      setTimeout(() => (img.style.display = "block"), 2000);
    });

    img.src = "https://picsum.photos/200/" + tile_height;
    img.alt = "Very cool picture";

    const overlay = document.createElement("a");
    overlay.setAttribute("class", "overlay");

    const likeButton = LikeButton.create();

    thumbnail.appendChild(img);
    thumbnail.appendChild(overlay);
    thumbnail.appendChild(likeButton);
    tile.appendChild(thumbnail);
  }
}

function getMinHeightCol(colList) {
  return ms_cols.reduce((curr, next) =>
    curr.scrollHeight > next.scrollHeight ? next : curr
  );
}

loadTiles(init_tile);

var addTile = setInterval(() => {
  if (getMinHeightCol(ms_cols).scrollHeight < CLIENT_HEIGHT) {
    init_tile++;
    loadTiles(1);
  } else {
    clearInterval(addTile);
  }
}, 3000);

window.addEventListener("scroll", function () {
  if (
    Math.ceil(window.pageYOffset) + window.screen.height >=
    document.body.scrollHeight
  ) {
    loadTiles(init_tile);
  }
});

function shinkImageToScreenSize(thumbnail) {
  thumbnail.style.height = Math.ceil(CLIENT_HEIGHT * 0.7) + "px";
  const expandFigButton = document.createElement("button");
  expandFigButton.setAttribute("class", "extendTile");
  expandFigButton.textContent = "Expand Image";
  expandFigButton.addEventListener("click", function resizeImage() {
    const img = thumbnail.querySelector("img");
    if (expandFigButton.textContent === "Expand Image") {
      thumbnail.style.height = img.height + "px";
      expandFigButton.textContent = "Compress It!";
    } else {
      thumbnail.style.height = Math.ceil(CLIENT_HEIGHT * 0.7) + "px";
      expandFigButton.textContent = "Expand Image";
    }
  });
  thumbnail.appendChild(expandFigButton);
  return thumbnail;
}
