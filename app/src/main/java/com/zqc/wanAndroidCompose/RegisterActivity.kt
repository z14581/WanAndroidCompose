package com.zqc.wanAndroidCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zqc.wanAndroidCompose.model.RegisterViewModel

class RegisterActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:RegisterViewModel = viewModel()


            Column {
                inputRegisterInfo()
                Button(onClick = {
                    viewModel.register(userName,passWord,rePassWord)
                }) {
                    Text("注册")
                }
            }
        }
    }
}
var userName by   mutableStateOf("")
var passWord by   mutableStateOf("")
var rePassWord by   mutableStateOf("")
@Composable
fun inputRegisterInfo(){
    registerInput(userName, { userName = it }, "请输入用户名",KeyboardOptions(keyboardType = KeyboardType.Text))
    registerInput(passWord, { passWord = it }, "请输入密码",KeyboardOptions(keyboardType = KeyboardType.Password))
    registerInput(rePassWord, { rePassWord = it }, "请再次输入密码",KeyboardOptions(keyboardType = KeyboardType.Password))
}


@Composable
fun registerInput(value:String,onValueChange: (String) -> Unit,hint:String,keyboardOptions: KeyboardOptions){
    TextField(value,
        onValueChange =onValueChange ,
        Modifier.background(Color.White).fillMaxWidth().padding(20.dp,2.dp,20.dp,2.dp).border(1.dp,
            Color.Gray,RoundedCornerShape(20.dp))
            .clip(RoundedCornerShape(20.dp)),
        placeholder = {
            Text(hint)
        },
        keyboardOptions = keyboardOptions,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            disabledTextColor = Color.Transparent,

            backgroundColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            cursorColor = Color.Gray
        )


    )
}

@Preview(showBackground = true)
@Composable
fun  preview(){
    val viewModel:RegisterViewModel = viewModel()
    var userName by remember {
        mutableStateOf("")
    }
    Column() {
        registerInput(userName, { userName = it }, "请输入用户名",KeyboardOptions(keyboardType = KeyboardType.Password))
        registerInput(passWord, { passWord = it }, "请输入密码",KeyboardOptions(keyboardType = KeyboardType.Password))
        registerInput(rePassWord, { rePassWord = it }, "请再次输入密码",KeyboardOptions(keyboardType = KeyboardType.Password))

        Button(onClick = {
            viewModel.register("","","")
        }) {
            Text("注册")
        }
    }


}

