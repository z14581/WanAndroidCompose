package com.zqc.wanAndroidCompose.model

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import com.zqc.wanAndroidCompose.base.BaseViewModel
import com.zqc.wanAndroidCompose.data.bean.Article
import com.zqc.wanAndroidCompose.data.bean.Tag
import com.zqc.wanAndroidCompose.network.ApiManager
import kotlinx.coroutines.launch

class TestViewModel : BaseViewModel() {

    var articles = mutableStateOf(listOf<Article>())

    var articleTests = mutableStateOf(
        listOf(
            Article(
                "", 1, "测试01", false, 1, "", false, 1, "", "", "", false,
                "", 1, "", "", "一天前", "", "", "", 1, 1, 1, 1,
                "", 1, "", listOf(), "", 1, 1, 1, 1
            ),
            Article(
                "", 1, "测试01", false, 1, "", false, 1, "", "", "", false,
                "", 1, "", "", "两天前", "", "", "", 1, 1, 1, 1,
                "", 1, "", listOf(), "", 1, 1, 1, 1
            ),
            Article(
                "", 1, "测试01", false, 1, "", false, 1, "", "", "", false,
                "", 1, "", "", "2023-04-03 08:45", "", "", "", 1, 1, 1, 1,
                "", 1, "", listOf(), "", 1, 1, 1, 1
            ),
            Article(
                "", 1, "测试01", false, 1, "", false, 1, "", "", "", false,
                "", 1, "", "", "2023-02-03 08:45", "", "", "", 1, 1, 1, 1,
                "", 1, "", listOf(), "", 1, 1, 1, 1
            )
        )
    )


    fun getArticles() {
        viewModelScope.launch {
            ApiManager.getArticles()
        }
    }
}