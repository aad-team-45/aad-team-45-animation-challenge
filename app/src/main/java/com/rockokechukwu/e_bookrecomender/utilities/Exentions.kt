package com.rockokechukwu.e_bookrecomender.utilities

/* convert String List to single String format*/

val List<String>.authorDisplayFormat
get() = this.joinToString( separator = " & ")


fun List<String>.authorDisPlayFormat() = this.joinToString( separator = " & ")