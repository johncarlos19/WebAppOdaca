// self.addEventListener('install', function(event) {
//   event.waitUntil(
//     caches.open('v1').then(function(cache) {
//       return cache.addAll([
//         'https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"',
//         'https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css',
//         '/dashboard/assets/css/style.css',
//         '/dashboard/assets/js/jquery.min.js',
//         '/dashboard/assets/js/popper.js',
//         '/dashboard/assets/js/bootstrap.min.js',
//         '/dashboard/assets/js/main.js',
//         '/catalogo/assets/js/databaseIndexedDB.js',
//         '/login',
//         // 'https://odaca.com.do/wp-content/uploads/2021/05/odaca-header.jpg',
//         '/dashboard/login.html'
//       ]);
//     })
//   );
// });
//
//
//
// self.addEventListener('activate', (event) => {
//   event.waitUntil((async () => {
//     // Enable navigation preload if it's supported.
//     // See https://developers.google.com/web/updates/2017/02/navigation-preload
//     if ('navigationPreload' in self.registration) {
//       await self.registration.navigationPreload.enable();
//     }
//   })());
//   // Tell the active service worker to take control of the page immediately.
//   self.clients.claim();
// });
//
// self.addEventListener('fetch', function(event) {
//   event.respondWith(caches.match(event.request).then(function(response) {
//     // caches.match() always resolves
//     // but in case of success response will have value
//     if (response !== undefined) {
//       return response;
//     } else {
//       return fetch(event.request).then(function (response) {
//         // response may be used only once
//         // we need to save clone to put one copy in cache
//         // and serve second one
//         let responseClone = response.clone();
//
//         caches.open('v1').then(function (cache) {
//           cache.put(event.request, responseClone);
//         });
//         return response;
//       }).catch(function () {
//         return caches.match('/sw-test/gallery/myLittleVader.jpg');
//       });
//     }
//   }));
// });



const version = "0.6.18";
const cacheName = `odaca-1`;
self.addEventListener('install', e => {
  e.waitUntil(
      caches.open(cacheName).then(cache => {
        return cache.addAll([
          'https://fonts.googleapis.com/css?family=Lato:300,400,700&display=swap"',
          'https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css',
          '../dashboard/assets/css/style.css',
          '../dashboard/assets/js/jquery.min.js',
          '../dashboard/assets/js/popper.js',
          '../dashboard/assets/js/bootstrap.min.js',
          '../dashboard/assets/js/main.js',
          '../catalogo/assets/js/databaseIndexedDB.js',
          '/login',
          '/catalogo/home',
          '/catalogo/producto',

          '/catalogo/configuracion',
          '../catalogo/catalogo.html',
          '../catalogo/configuration.html',
          // 'https://odaca.com.do/wp-content/uploads/2021/05/odaca-header.jpg',
          '../dashboard/login.html',
          '../catalogo/index.html',
          "../catalogo/assets/bootstrap/css/bootstrap.min.css",
          "https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i",
          "https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic",
          "https://fonts.googleapis.com/css?family=Montserrat:400,700",
          "https://fonts.googleapis.com/css?family=Nunito:400,600,800",
          "https://fonts.googleapis.com/css?family=Roboto+Slab:300,400|Roboto:300,400,700",
          "https://use.fontawesome.com/releases/v5.12.0/css/all.css",
          "https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css",
          "https://cdnjs.cloudflare.com/ajax/libs/material-design-icons/3.0.1/iconfont/material-icons.min.css",
          "../catalogo/assets/fonts/fontawesome5-overrides.min.css",
          "../catalogo/assets/css/--mp---Multiple-items-slider-responsive.css",
          "../catalogo/assets/css/animated-services.css",
          "../catalogo/assets/css/Article-List.css",
          "../catalogo/assets/css/best-carousel-slide.css",
          "../catalogo/assets/css/Bold-BS4-Pricing-Table-Style-55-2.css",
          "../catalogo/assets/css/Bold-BS4-Pricing-Table-Style-55.css",
          "../catalogo/assets/css/Check-Out-Page-v100.css",
          "https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css",
          "../catalogo/assets/css/milagroso.css",
          "../catalogo/assets/css/Responsive-Client-Grid.css",
          "../catalogo/assets/css/Studious-selectbox.css",
          "../catalogo/assets/css/Team-Grid.css",
          "../catalogo/assets/js/datatable/datatables.min.css",
          "../catalogo/assets/css/configuration.css",
          '../js/axios.min.js',
          "../js/webworker-ajax.js ",




          "../catalogo/assets/img/marcas/logo%20odaca.jpg",
          "../catalogo/assets/img/marcas/x1000.jpeg",
          "../catalogo/assets/img/marcas/racingturbo.jpeg",
          "../catalogo/assets/img/marcas/aldrich.jpg",
          "../catalogo/assets/img/marcas/turboplatinium.jpeg",
          "../catalogo/assets/img/marcas/tmrjodio.png",
          "../catalogo/assets/img/marcas/eliteracing.jpg",
          "../catalogo/assets/img/slide/motores1-bg-min.jpg",
          "../catalogo/assets/img/slide/motores2-bg-min.jpg",
          "../catalogo/assets/img/slide/motores2-bg-min.png",
          "../catalogo/assets/img/slide/motores-bg-min.jpg",
          "../catalogo/assets/img/slide/odaco-slide.jpg",
          "../catalogo/assets/img/5ba289e09f24ea6d65fc8a70_noimage.jpg",
          "../catalogo/assets/img/moto02.png",
          "../catalogo/assets/img/moto04.png",
          "https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js",
          "https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js",
          "../catalogo/assets/js/smoothproducts.min.js",
          "../catalogo/assets/js/theme.js",
          "../catalogo/assets/js/--mp---Multiple-items-slider-responsive-1.js",
          "../catalogo/assets/js/--mp---Multiple-items-slider-responsive.js",
          "../catalogo/assets/js/milagroso2.js",
          "../catalogo/assets/js/Studious-selectbox.js",
          "../catalogo/assets/js/catalogo.js",
          "../catalogo/assets/js/ajaxpeticiones.js",
          // "https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js",
          // "https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js",
          // "https://code.jquery.com/jquery-3.3.1.min.js",
          // "https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js",
          // "https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js",
          // "https://cdn.datatables.net/responsive/2.2.1/js/dataTables.responsive.min.js",
          // "https://cdn.datatables.net/responsive/2.2.1/js/responsive.bootstrap4.min.js",
          // "https://cdn.datatables.net/select/1.2.0/js/dataTables.select.min.js"

          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bootstrap.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bootstrap4.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bootstrap5.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bulma.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.dataTables.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.foundation.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.jqueryui.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.semanticui.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/css/jquery.dataTables.css",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_asc.png",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_asc_disabled.png",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_both.png",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_desc.png",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_desc_disabled.png",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bootstrap.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bootstrap4.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bootstrap5.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bulma.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.dataTables.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.foundation.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.jqueryui.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.semanticui.js",
          "../catalogo/assets/js/datatable/DataTables-1.10.25/js/jquery.dataTables.js",
          "../catalogo/assets/js/datatable/datatables.css",
          "../catalogo/assets/js/datatable/datatables.js",

          "../dashboard/assets/js/jquery.easing.min.js",
          "../dashboard/assets/js/baguetteBox.min.js"









          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.dataTables.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/jquery.dataTables.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bootstrap.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.bootstrap.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.jqueryui.js",
          // "../catalogo/assets/js/datatable/datatables.css",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.bulma.css",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.bootstrap.css",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.bootstrap4.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.semanticui.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.jqueryui.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.foundation.css",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.dataTables.js",
          // "../catalogo/assets/js/datatable/DateTime-1.1.0/js/dataTables.dateTime.min.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.foundation.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.semanticui.js",
          // "../catalogo/assets/js/datatable/DateTime-1.1.0/css/dataTables.dateTime.min.css",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.bulma.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.bootstrap4.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bootstrap5.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_desc_disabled.png",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bootstrap5.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.bootstrap5.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bulma.css",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.semanticui.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.bootstrap.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.bootstrap5.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.foundation.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.jqueryui.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.dataTables.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.jqueryui.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.foundation.css",
          // "../catalogo/assets/js/datatable/datatables.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.semanticui.css",
          // "../catalogo/assets/js/datatable/DateTime-1.1.0/css/dataTables.dateTime.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.bootstrap5.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.bootstrap4.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_desc.png",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bootstrap.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.bootstrap5.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_asc.png",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.bootstrap4.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_both.png",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.jqueryui.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bootstrap4.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.foundation.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/jquery.dataTables.css",
          // "../catalogo/assets/js/datatable/DateTime-1.1.0/js/dataTables.dateTime.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.semanticui.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/dataTables.select.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.semanticui.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.bulma.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.bulma.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.dataTables.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/dataTables.responsive.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.jqueryui.js",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/css/dataTables.dataTables.css",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/js/responsive.bulma.js",
          // "../catalogo/assets/js/datatable/Select-1.3.3/css/select.foundation.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/images/sort_asc_disabled.png",
          // "../catalogo/assets/js/datatable/Select-1.3.3/js/select.bootstrap.js",
          // "../catalogo/assets/js/datatable/Responsive-2.2.9/css/responsive.bootstrap4.css",
          // "../catalogo/assets/js/datatable/DataTables-1.10.25/js/dataTables.dataTables.js"







        ])
            .then(() => self.skipWaiting());
      })
  );
});

self.addEventListener('activate', event => {
  event.waitUntil(self.clients.claim());
});

self.addEventListener('fetch', event => {
  event.respondWith(
      caches.open(cacheName)
          .then(cache => cache.match(event.request, {ignoreSearch: true}))
          .then(response => {
            return response || fetch(event.request);
          })
  );
});

