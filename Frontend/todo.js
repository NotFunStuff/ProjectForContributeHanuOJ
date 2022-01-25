const app = Vue.createApp({
    data() {
        return {
            hide: true,
            list: [],
            isDone: false
        }
    },

    methods: {
        deleteToDo(index) {
            if (confirm("Are you f*ing sure you want to delete this todo?")) {
                this.list.splice(index, 1)
            }
        },

        addButton() {
            this.hide = !this.hide
        },

        hover(index) {
            this.list[index].hover = true;
        },

        mouseLeave(index) {
            this.list[index].hover = false;
        },

        getData() {
            this.isDone = false
            fetch("https://jsonplaceholder.typicode.com/todos?_start=0&_limit=5&_delay=3000", {
                method: 'GET'
            }).then((response) => {
                if (response.ok) {
                    return response.json()
                } else {
                    console.log("fk");
                }
            }).then((data) => {
                this.isDone = true;
                var toAdd = []
                data.forEach(element => {
                    element.hover = false;
                    toAdd.push(element)
                });
                this.list = toAdd
            })
        },

        mark(index) {
            if (this.list[index].completed === true) {
                this.list[index].completed = false
            } else {
                this.list[index].completed = true
            }
        },

        add() {
            var title = document.getElementById("title").value;
            if (title !== "") {
                var temp = {
                    title: title,
                    completed: false,
                    hover: false
                }
                this.list.push(temp)
                document.getElementById("title").value = ""
            } else {
                alert('Are you dump? \nTitle is empty')
            }
        }
    },

    mounted() {
        this.getData()
    }
})

app.mount('#vue')