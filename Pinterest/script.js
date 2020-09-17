document.addEventListener("DOMContentLoaded", function (event) {
  const API_URL = "";

  var ms_cols = Array.from(document.querySelectorAll(".cell"));

  var sheet = window.document.styleSheets[0];

  sheet.insertRule(
    `.cell{flex:${(1 / ms_cols.length) * 0.9}`,
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
      let current_col = getMinHeightCol(ms_cols);
      let tile = document.createElement("div");
      tile.setAttribute("class", "tile");
      tile.style.height = tile_height + "px";
      let rand = Math.floor(Math.random() * 256);
      tile.style.backgroundColor = `rgb(${rand}, ${128}, ${256 - rand})`;
      tile.style.backgroundImage =
        "url(https://picsum.photos/200/" + tile_height + ")";
      current_col.appendChild(tile);
    }
  }

  function getMinHeightCol(colList) {
    return colList.reduce((curr, next) =>
      curr.scrollHeight > next.scrollHeight ? next : curr
    );
  }

  loadTiles(4);

  var container = document.querySelector(".container");
  container.addEventListener("scroll", function () {
    if (
      Math.ceil(container.scrollTop) + container.clientHeight >=
      container.scrollHeight
    ) {
      setTimeout(() => loadTiles(3), 1500);
    }
  });
});
