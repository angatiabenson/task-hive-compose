package ke.co.banit.taskhive.ui.todo

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ke.co.banit.taskhive.ui.todo.components.AddTaskComponent
import ke.co.banit.taskhive.ui.todo.components.TodoItem
import ke.co.banit.taskhive.ui.todo.models.TodoModel

@Preview(showBackground = true)
@Composable
fun TodoScreen(modifier: Modifier = Modifier) {
    var todos by remember {
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
    var taskName by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 70.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            )
            {

                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "TaskHive", style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(12.dp))
                TodoItemsSection(todos = todos)
            }
        }
        AddTaskComponent(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(70.dp),
            taskName = taskName,
            onTaskNameChange = {
                taskName = it
            }
        ) {
            val newTodo = TodoModel(
                id = todos.size + 1,
                title = taskName,
                completed = false
            )
            todos = todos + newTodo
            taskName = ""
        }
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