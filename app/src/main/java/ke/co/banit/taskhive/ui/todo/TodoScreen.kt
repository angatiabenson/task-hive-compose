package ke.co.banit.taskhive.ui.todo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ke.co.banit.taskhive.ui.todo.components.TodoItem
import ke.co.banit.taskhive.ui.todo.models.TodoModel

@Composable
fun TodoScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        val todos by remember {
            mutableStateOf(
                listOf(
                    TodoModel(
                        id = 1,
                        title = "Learn Jetpack Compose",
                        completed = false
                    ),
                    TodoModel(
                        id = 2,
                        title = "State Management in Jetpack Compose",
                        completed = false
                    ),
                    TodoModel(
                        id = 3,
                        title = "Navigation in Jetpack Compose",
                        completed = false
                    ),
                    TodoModel(
                        id = 4,
                        title = "Jetpack Compose for Beginners",
                        completed = false
                    )
                )
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(text = "TaskHive", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(12.dp))
        TodoItemsSection(todos = todos)
    }
}

@Composable
fun TodoItemsSection(modifier: Modifier = Modifier, todos: List<TodoModel>) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(todos.size){index->
            TodoItem(todo = todos[index])
        }
    }
}