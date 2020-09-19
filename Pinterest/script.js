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

function loadTiles(row_count) {
  for (let i = 0; i < row_count * row_count; i++) {
    let tile_height =
      image_heights[Math.floor(Math.random() * image_heights.length)];
    const current_col = getMinHeightCol(ms_cols);

    const tile = document.createElement("figure");
    tile.setAttribute("class", "tile");

    const thumbnail = document.createElement("div");
    thumbnail.setAttribute("class", "thumbnail");
    const rand = Math.floor(Math.random() * 256);
    thumbnail.style.backgroundColor = `rgb(${rand}, ${128}, ${256 - rand})`;

    const img = document.createElement("img");
    img.src = "https://picsum.photos/200/" + tile_height;
    img.alt = "Very cool picture";
    img.addEventListener("load", (event) => (img.width = img.naturalWidth));

    const overlay = document.createElement("a");
    overlay.setAttribute("class", "overlay");

    thumbnail.style.height = tile_height + "px";

    const likeButton = LikeButton.create();

    thumbnail.appendChild(img);
    thumbnail.appendChild(overlay);
    thumbnail.appendChild(likeButton);
    tile.appendChild(thumbnail);

    current_col.appendChild(tile);
  }
}

function getMinHeightCol(colList) {
  return colList.reduce((curr, next) =>
    curr.scrollHeight > next.scrollHeight ? next : curr
  );
}

loadTiles(4);

var container = document.querySelector(".main");
container.addEventListener("scroll", function () {
  if (
    Math.ceil(container.scrollTop) + container.clientHeight >=
    container.scrollHeight
  ) {
    setTimeout(() => loadTiles(3), 1500);
  }
});

// });
