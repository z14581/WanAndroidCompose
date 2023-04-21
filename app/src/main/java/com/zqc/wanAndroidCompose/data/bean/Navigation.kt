package com.zqc.wanAndroidCompose.data.bean

import com.zqc.wanAndroidCompose.data.bean.Article

/**
 * 导航实体
 * @author LTP  2022/4/7
 */
data class Navigation(
    var articles: List<Article>,
    var cid: Int,
    var name: String
)