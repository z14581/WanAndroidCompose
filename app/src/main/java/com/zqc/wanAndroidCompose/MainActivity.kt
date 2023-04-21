package com.zqc.wanAndroidCompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.zqc.wanAndroidCompose.data.bean.Article
import com.zqc.wanAndroidCompose.model.TestViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val viewModel:TestViewModel = viewModel()

            Button(onClick = {
                println("发起网络请求")
                viewModel.getArticles()
            }) {
                Text("获取文章列表")
            }



            val list :List<Article> = viewModel.articleTests.value
            LazyColumn(){
                items(list){
                    Row(Modifier.fillMaxWidth().background(Color.Blue)) {
                        Text(it.author,
                            Modifier
                                .weight(1f)
                                )
                        Text(it.niceShareDate,
                            Modifier
                                .padding(8.dp, 0.dp, 12.dp, 0.dp)
                                .width(200.dp))


                    }
                }
            }



        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val viewModel:TestViewModel = viewModel()
    var list :List<Article> = viewModel.articleTests.value
    LazyColumn(){
        items(list){
            Row(Modifier.fillMaxWidth().background(Color.Blue)) {
                Text(it.author,
                    Modifier
                        .weight(1f)
                )
                Text(it.niceShareDate,
                    Modifier
                        .padding(8.dp, 0.dp, 12.dp, 0.dp)
                        .width(200.dp))


            }
        }
    }




}