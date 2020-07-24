package com.example.a40_drawerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_layout.*

class MainActivity : AppCompatActivity() {
    //AppBarConfiguration是配置抽屉上的控制条的
    private lateinit var appBarConfiguration: AppBarConfiguration
    //NavController是配置导航的控制器的
    private lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //去掉默认的导航条后，加入可收缩的导航条
        setSupportActionBar(toolbar)

        /*
            装入
         */
        //fragment就是activity_main中加入的NavHostFragment
        navController = findNavController(R.id.fragment)
        //获取导航图表:navController.graph，抽屉:drawerLayout
//        //第一种方式
//        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)
        //第二种方式，使每一个菜单顶部上面的按键，按下后直接进入抽屉
        val set = setOf(R.id.textFragment,R.id.listFragment,R.id.pagerFragment)
        appBarConfiguration = AppBarConfiguration(set,drawerLayout)

        /*
            配置
         */
        setupActionBarWithNavController(navController,appBarConfiguration)
        navigationView.setupWithNavController(navController)

    }

    /**
     * 使首页的按键可用(也就是刚开启应用进入的第一个菜单的界面)，按下就进入抽屉
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}