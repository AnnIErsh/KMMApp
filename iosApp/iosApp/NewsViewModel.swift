//
//  NewsViewModel.swift
//  iosApp
//
//  Created by Anna Ershova on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import Foundation
import shared

class NewsViewModel: ObservableObject, INewsListView {
    @Published var items: [NewsItem] = [NewsItem]()
    
    private lazy var presenter: INewsListPresenter = {
        let presenter = NewsListPresenter()
        presenter.attachView(view: self)
        return presenter
    }()
    
    func setupNews(data: NewsList) {
        self.items = data.articles
    }
    
    func loadNews() {
         presenter.loadNews()
     }
 }
