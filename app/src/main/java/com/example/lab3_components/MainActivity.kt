package com.example.lab3_components // O el nombre de tu paquete

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.lab3_components.ui.theme.Lab3componentsTheme // Asegúrate de que el nombre del tema sea correcto

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // NOTA: Para que el DemoImage funcione, agrega un archivo de imagen
        // a tu carpeta res/drawable y llámalo 'placeholder_image.png'
        setContent {
            Lab3componentsTheme {
                // Puedes llamar a cualquiera de las funciones 'Demo...' aquí para probarla en el emulador.
                // Por defecto, se muestra un texto de bienvenida.
                Column(
                    modifier = Modifier.fillMaxSize().padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        "Usa el modo 'Split' de Android Studio para ver los Previews de cada componente.",
                        fontSize = 18.sp
                    )
                }
            }
        }
    }
}

// -----------------------------------------------------------------------------
// --- CONTENEDORES ---
// -----------------------------------------------------------------------------

@Composable
fun DemoLazyColumn() {
    LazyColumn(contentPadding = PaddingValues(16.dp)) {
        items(5) { index ->
            Text(text = "Item de columna #$index", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true, name = "Contenedor: LazyColumn")
@Composable
fun PreviewLazyColumn() {
    DemoLazyColumn()
}

@Composable
fun DemoLazyRow() {
    LazyRow(contentPadding = PaddingValues(16.dp)) {
        items(5) { index ->
            Text(text = "Item #$index", fontSize = 20.sp, modifier = Modifier.padding(8.dp))
        }
    }
}

@Preview(showBackground = true, name = "Contenedor: LazyRow")
@Composable
fun PreviewLazyRow() {
    DemoLazyRow()
}

@Composable
fun DemoGrid() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier.height(200.dp)
    ) {
        items(9) { index ->
            Card(modifier = Modifier.padding(4.dp).aspectRatio(1f)) {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
                    Text("Grid $index")
                }
            }
        }
    }
}

@Preview(showBackground = true, name = "Contenedor: Grid")
@Composable
fun PreviewGrid() {
    DemoGrid()
}

@Composable
fun DemoConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxWidth().height(100.dp)) {
        val (button, text) = createRefs()
        Button(
            onClick = { /*...*/ },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            }
        ) {
            Text("Botón")
        }
        Text("Texto abajo", Modifier.constrainAs(text) {
            top.linkTo(button.bottom, margin = 8.dp)
            start.linkTo(button.start)
        })
    }
}

@Preview(showBackground = true, name = "Contenedor: ConstraintLayout")
@Composable
fun PreviewConstraintLayout() {
    DemoConstraintLayout()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoScaffold() {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Mi App") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Icon(Icons.Default.Add, contentDescription = "Agregar")
            }
        }
    ) { padding ->
        Box(modifier = Modifier.padding(padding).fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Contenido del Scaffold")
        }
    }
}

@Preview(showBackground = true, name = "Contenedor: Scaffold")
@Composable
fun PreviewScaffold() {
    DemoScaffold()
}

@Composable
fun DemoSurface() {
    Surface(
        modifier = Modifier.size(120.dp),
        color = MaterialTheme.colorScheme.primaryContainer,
        shadowElevation = 8.dp,
        shape = MaterialTheme.shapes.medium
    ) {
        Box(contentAlignment = Alignment.Center) {
            Text("Surface")
        }
    }
}

@Preview(showBackground = true, name = "Contenedor: Surface")
@Composable
fun PreviewSurface() {
    DemoSurface()
}

@Composable
fun DemoChip() {
    AssistChip(
        onClick = { },
        label = { Text("Etiqueta Chip") },
        leadingIcon = { Icon(Icons.Default.Star, contentDescription = null) }
    )
}

@Preview(showBackground = true, name = "Contenedor: Chip")
@Composable
fun PreviewChip() {
    DemoChip()
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun DemoFlowRow() {
    FlowRow(modifier = Modifier.padding(8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        repeat(8) {
            AssistChip(onClick = {}, label = { Text("Tag ${it + 1}") })
        }
    }
}

@Preview(showBackground = true, name = "Contenedor: FlowRow")
@Composable
fun PreviewFlowRow() {
    DemoFlowRow()
}

// FlowColumn es análogo a FlowRow pero en vertical.
// BackdropScaffold es un componente obsoleto de Material 2.

// -----------------------------------------------------------------------------
// --- CONTROLES ---
// -----------------------------------------------------------------------------

@Composable
fun DemoAlertDialog() {
    // Los diálogos no se pueden previsualizar directamente en el modo diseño.
    // Se muestra el botón que lo activaría en la app real.
    Button(onClick = {}) {
        Text("Mostrar AlertDialog")
    }
}

@Preview(showBackground = true, name = "Control: AlertDialog")
@Composable
fun PreviewAlertDialog() {
    DemoAlertDialog()
}

@Composable
fun DemoCard() {
    Card(
        modifier = Modifier.size(width = 150.dp, height = 80.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Contenido de la Card")
        }
    }
}

@Preview(showBackground = true, name = "Control: Card")
@Composable
fun PreviewCard() {
    DemoCard()
}

@Composable
fun DemoCheckbox() {
    var isChecked by remember { mutableStateOf(false) }
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = isChecked, onCheckedChange = { isChecked = it })
        Text(if (isChecked) "Seleccionado" else "No seleccionado")
    }
}

@Preview(showBackground = true, name = "Control: Checkbox")
@Composable
fun PreviewCheckbox() {
    DemoCheckbox()
}

@Composable
fun DemoFloatingActionButton() {
    FloatingActionButton(onClick = {}) {
        Icon(Icons.Default.Add, contentDescription = "FAB")
    }
}

@Preview(showBackground = true, name = "Control: FloatingActionButton")
@Composable
fun PreviewFloatingActionButton() {
    DemoFloatingActionButton()
}

@Composable
fun DemoIcon() {
    Icon(Icons.Filled.Favorite, contentDescription = "Icono", tint = MaterialTheme.colorScheme.primary)
}

@Preview(showBackground = true, name = "Control: Icon")
@Composable
fun PreviewIcon() {
    DemoIcon()
}

@Composable
fun DemoImage() {
    // Se muestra un texto como placeholder para el preview.
    // Para que funcione en el emulador, añade una imagen llamada 'placeholder_image.png' a tu carpeta res/drawable
    // y descomenta las siguientes líneas:
    // Image(
    //     painter = painterResource(id = R.drawable.placeholder_image),
    //     contentDescription = "Imagen de ejemplo",
    //     modifier = Modifier.size(100.dp)
    // )
    Box(modifier = Modifier.size(100.dp), contentAlignment = Alignment.Center) {
        Text("(Aquí va una imagen)")
    }
}

@Preview(showBackground = true, name = "Control: Image")
@Composable
fun PreviewImage() {
    DemoImage()
}

@Composable
fun DemoProgressBar() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        CircularProgressIndicator()
        Spacer(Modifier.height(16.dp))
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth(0.7f))
    }
}

@Preview(showBackground = true, name = "Control: ProgressBar")
@Composable
fun PreviewProgressBar() {
    DemoProgressBar()
}

@Composable
fun DemoRadioButton() {
    var selected by remember { mutableStateOf("Opción A") }
    Row {
        RadioButton(selected = selected == "Opción A", onClick = { selected = "Opción A" })
        Text("A")
        Spacer(Modifier.width(16.dp))
        RadioButton(selected = selected == "Opción B", onClick = { selected = "Opción B" })
        Text("B")
    }
}

@Preview(showBackground = true, name = "Control: RadioButton")
@Composable
fun PreviewRadioButton() {
    DemoRadioButton()
}

@Composable
fun DemoSlider() {
    var sliderValue by remember { mutableFloatStateOf(0.5f) }
    Slider(value = sliderValue, onValueChange = { sliderValue = it })
}

@Preview(showBackground = true, name = "Control: Slider")
@Composable
fun PreviewSlider() {
    DemoSlider()
}

@Composable
fun DemoSpacer() {
    Row {
        Text("Izquierda")
        Spacer(modifier = Modifier.width(32.dp))
        Text("Derecha")
    }
}

@Preview(showBackground = true, name = "Control: Spacer")
@Composable
fun PreviewSpacer() {
    DemoSpacer()
}

@Composable
fun DemoSwitch() {
    var isChecked by remember { mutableStateOf(true) }
    Switch(checked = isChecked, onCheckedChange = { isChecked = it })
}

@Preview(showBackground = true, name = "Control: Switch")
@Composable
fun PreviewSwitch() {
    DemoSwitch()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTopAppBar() {
    TopAppBar(
        title = { Text("Título") },
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(Icons.Default.Menu, "Menú")
            }
        }
    )
}

@Preview(showBackground = true, name = "Control: TopAppBar")
@Composable
fun PreviewTopAppBar() {
    DemoTopAppBar()
}

@Composable
fun DemoBottomNavigation() {
    NavigationBar {
        NavigationBarItem(
            selected = true,
            onClick = {},
            icon = { Icon(Icons.Default.Home, null) },
            label = { Text("Home") }
        )
        NavigationBarItem(
            selected = false,
            onClick = {},
            icon = { Icon(Icons.Default.Settings, null) },
            label = { Text("Ajustes") }
        )
    }
}

@Preview(showBackground = true, name = "Control: BottomNavigation")
@Composable
fun PreviewBottomNavigation() {
    DemoBottomNavigation()
}

@Composable
fun DemoDivider() {
    Column {
        Text("Contenido arriba")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        Text("Contenido abajo")
    }
}

@Preview(showBackground = true, name = "Control: Divider")
@Composable
fun PreviewDivider() {
    DemoDivider()
}

@Composable
fun DemoDropDownMenu() {
    // El menú desplegable (DropdownMenu) no es visible en un preview estático.
    // Se muestra el botón que lo activaría.
    Box {
        Button(onClick = {}) { Text("Mostrar Menú") }
    }
}

@Preview(showBackground = true, name = "Control: DropDownMenu")
@Composable
fun PreviewDropDownMenu() {
    DemoDropDownMenu()
}

@Composable
fun DemoNavigationRail() {
    NavigationRail {
        NavigationRailItem(selected = true, onClick = {}, icon = { Icon(Icons.Default.Home, null) }, label = { Text("Home") })
        NavigationRailItem(selected = false, onClick = {}, icon = { Icon(Icons.Default.Favorite, null) }, label = { Text("Favs") })
    }
}

@Preview(showBackground = true, name = "Control: NavigationRail")
@Composable
fun PreviewNavigationRail() {
    DemoNavigationRail()
}

@Composable
fun DemoOutlinedTextField() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(value = text, onValueChange = { text = it }, label = { Text("Usuario") })
}

@Preview(showBackground = true, name = "Control: OutlinedTextField")
@Composable
fun PreviewOutlinedTextField() {
    DemoOutlinedTextField()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoTooltip() {
    // Para ver el tooltip, mantén presionado el ícono en un preview interactivo.
    TooltipBox(
        positionProvider = TooltipDefaults.rememberPlainTooltipPositionProvider(),
        tooltip = { PlainTooltip { Text("Info extra") } },
        state = rememberTooltipState()
    ) {
        Icon(Icons.Default.Info, contentDescription = "Info")
    }
}

@Preview(showBackground = true, name = "Control: Tooltip")
@Composable
fun PreviewTooltip() {
    DemoTooltip()
}

// Los componentes Pager, Snackbar y TabRow son interactivos y se aprecian mejor
// en un emulador o preview interactivo, por lo que se omiten para mantener la simplicidad.