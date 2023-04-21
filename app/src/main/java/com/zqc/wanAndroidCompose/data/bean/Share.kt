package com.zqc.wanAndroidCompose.data.bean

import com.btpj.lib_base.data.bean.PageResponse
import com.zqc.wanAndroidCompose.data.bean.Article
import com.zqc.wanAndroidCompose.data.bean.CoinInfo

/**
 * 我的分享
 *
 * @author LTP  2022/4/13
 */
data class Share(
    var coinInfo: CoinInfo,
    var shareArticles: PageResponse<Article>
)