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
          '/catalogo/producto',
          '../catalogo/catalogo.html'
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

