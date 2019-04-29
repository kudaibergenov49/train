var trainApi = Vue.resource('/train{/id}');

Vue.component('train-form', {
    props: ['trains', 'trainAttr'],
    data: function () {
        return {
            text: '',
            id: ''
        }
    },
    watch: {
        trainAttr: function (newVal) {
            this.text = newVal.text;
            this.id = newVal.id;
        }
    },
    template:
        '<div>' +
        '<input type="text" placeholder="ВВЕДИТЕ ДАННЫЕ" v-model="text" />' +
        '<input type="button" value="Save" @click="save" />' +
        '</div>',
    methods: {
        save: function () {
            try {
                var value = {text: this.text};
                trainApi.save({}, value).then(result => {
                        if (result.data === "") {
                            alert("Неправильно введены данные: данные не должны повторятся и должны состоять из 0 и 1")
                        } else {
                            result.json().then(
                                data => {
                                    this.trains.push(data);
                                    this.text = ''
                                })
                        }
                    }
                )
            } catch (e) {
                alert("error")
            }
        }
    }
});

Vue.component('train-row', {
    props: ['train', 'trains'],
    template: '<div>' +
        '<p>id: ({{ train.id }})</p>  <p> value: {{ train.value }}</p> <p>length: {{train.count}}</p>' +
        '<span style="position: absolute; right: 0">' +
        '<input type="button" value="del" @click="del" />' +
        '</span>' +
        '</div>',
    methods: {
        del: function () {
            trainApi.remove({id: this.train.id}).then(result => {
                if (result.ok) {
                    this.trains.splice(this.trains.indexOf(this.train), 1)
                }
            })
        }
    }
});

Vue.component('trains-list', {
    props: ['trains'],
    data: function () {
        return {
            train: null
        }
    },
    template:
        '<div style="position: relative; width: 300px;">' +
        '<train-form :trains="trains" :trainAttr="train" />' +
        '<train-row v-for="train in trains" :key="train.id" :train="train" ' +
        ':trains="trains" />' +
        '</div>',
    created: function () {
        trainApi.get().then(result =>
            result.json().then(data =>
                data.forEach(train => this.trains.push(train))
            )
        )
    },
    methods: {}
});

var app = new Vue({
    el: '#app',
    template: '<trains-list :trains="trains" />',
    data: {
        trains: []
    }
});