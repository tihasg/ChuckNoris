package com.tiago.chucknoris.piada

import com.tiago.chucknoris.api.ChuckApi
import javax.inject.Inject

class PiadaRepository @Inject constructor(val api: ChuckApi) : PiadaContracts.Repository {
    override fun getRandomJoke(category: String)=  api.randomJoke(category)
}