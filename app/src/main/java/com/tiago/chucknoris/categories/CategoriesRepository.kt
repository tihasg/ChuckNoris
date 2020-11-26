package com.tiago.chucknoris.categories

import com.tiago.chucknoris.api.ChuckApi
import com.tiago.chucknoris.categories.CategoriesContracts.Repository
import javax.inject.Inject

class CategoriesRepository @Inject constructor(val api: ChuckApi) : Repository {
    override fun listCategories() = api.listCategories()
}
