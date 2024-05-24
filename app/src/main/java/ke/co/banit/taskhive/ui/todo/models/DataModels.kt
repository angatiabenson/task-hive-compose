package ke.co.banit.taskhive.ui.todo.models

data class TodoModel(
    val id: Int,
    val title: String,
    var completed: Boolean
)