require.config({
    shim: {
      'bootstrap': {
        deps: ['jquery']
      },
      'select2': {
        deps: ['jquery', 'css!../css/select2.css']
      },
      'sweetAlert': {
        //These script dependencies should be loaded before loading
        deps: ['css!/css/sweet-alert.css']
      },
      'jquery_validate': {
        deps: ['jquery', 'jquery_form']
      },
      'jquery_form': {
        deps: ['jquery']
      },
    },
    paths : {
      jquery: 'js/jquery.min',
      jquery_form: 'js/jquery.form',
      jquery_validate: '/js/jquery.validate',
      select2: '/js/select2',
      sweetAlert: '/js/sweet-alert',
    },
    map:{
      '*': {
        'css': '/css/css.min' // or whatever the path to require-css is
      }
    }
})