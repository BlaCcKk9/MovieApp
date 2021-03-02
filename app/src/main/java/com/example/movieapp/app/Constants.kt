package com.example.movieapp.app


const val CONNECT_TIMEOUT: Long = 120
const val WRITE_TIMEOUT: Long = 120
const val READ_TIMEOUT: Long = 120

const val VERSION = "3"
const val BASE_URL = "base_url"
const val API_KEY = "226d57aee86660948642b81ecba440f8"

const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"
const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/"

const val IMAGE_SIZE_W185 = "w185"
const val BACKDROP_SIZE_W780 = "w780"

const val IMAGE_URL = IMAGE_BASE_URL + IMAGE_SIZE_W185
const val BACKDROP_URL = IMAGE_BASE_URL + BACKDROP_SIZE_W780