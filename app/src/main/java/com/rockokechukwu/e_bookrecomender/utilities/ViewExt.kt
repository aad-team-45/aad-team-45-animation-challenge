package com.rockokechukwu.e_bookrecomender.utilities

import android.view.View

/* hides progresBar*/
fun View.hide(){
    this.visibility = View.INVISIBLE
}

/*shows progressBar*/
fun View.show(){
    this.visibility = View.VISIBLE
}