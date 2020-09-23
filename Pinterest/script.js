// document.addEventListener("DOMContentLoaded", function (event) {
class LikeButton {
  static create() {
    const likeButton = document.createElement("button");
    likeButton.setAttribute("class", "likeButton");
    likeButton.textContent = "Like";
    return likeButton;
  }
}

var init_tile = 0;

const API_URL = "http://localhost:8080/Pinterest/api/all";

const CLIENT_HEIGHT = window.screen.availHeight;

var ms_cols = Array.from(document.querySelectorAll(".col"));

var sheet = window.document.styleSheets[0];

var data = [];

sheet.insertRule(
  `.col{flex:${(1 / ms_cols.length) * 0.9}`,
  sheet.cssRules.length
);

function loadTiles(qual) {
  if (data.length == 0) {
    window.removeEventListener("scroll", updateTile);
    return;
  }
  for (let i = 0; i < qual * ms_cols.length; i++) {
    const tile = document.createElement("figure");
    tile.setAttribute("class", "tile");

    const thumbnail = document.createElement("div");
    thumbnail.setAttribute("class", "thumbnail");
    const rand = Math.floor(Math.random() * 256);
    thumbnail.style.backgroundColor = `rgb(${rand}, ${128}, ${256 - rand})`;

    const img = new Image();
    const caption = document.createElement("figcaption");
    let imgData = data.pop();
    caption.innerHTML = imgData.caption;

    img.style.display = "none";

    img.addEventListener("load", () => {
      thumbnail.style.height = img.naturalHeight + "px"; // img.height
      if (img.height > CLIENT_HEIGHT) shinkImageToScreenSize(thumbnail);
      img.height = img.naturalHeight;
      img.width = img.naturalWidth;
      const current_col = getMinHeightCol();
      current_col.appendChild(tile);
      current_col.style.height = current_col.scrollHeight;
      setTimeout(() => (img.style.display = "block"), 2000);
    });

    img.src = imgData.srcset;
    img.alt = "Very cool picture";

    const overlay = document.createElement("a");
    overlay.setAttribute("class", "overlay");

    const likeButton = LikeButton.create();

    thumbnail.appendChild(img);
    thumbnail.appendChild(overlay);
    thumbnail.appendChild(likeButton);
    tile.appendChild(thumbnail);
    tile.append(caption);
  }
}

function init(cb) {
  const promise = fetch(API_URL);
  promise
    .then(function (response) {
      const processingPromise = response.json();
      return processingPromise;
    })
    .then(function (processedPromise) {
      data = processedPromise;
      loadTiles(init_tile);
      cb();
    });
}

function getMinHeightCol() {
  return ms_cols.reduce((curr, next) =>
    curr.scrollHeight > next.scrollHeight ? next : curr
  );
}

init(function addMoreTile() {
  var addTile = setInterval(() => {
    if (getMinHeightCol().scrollHeight < CLIENT_HEIGHT) {
      init_tile++;
      loadTiles(1);
    } else {
      clearInterval(addTile);
    }
  }, 3000);
});

var updateTile = function () {
  if (
    Math.ceil(window.pageYOffset) + window.screen.height >=
    document.body.scrollHeight
  ) {
    loadTiles(init_tile);
  }
};

window.addEventListener("scroll", updateTile);

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
// });
