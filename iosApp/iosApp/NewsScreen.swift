//
//  NewsScreen.swift
//  iosApp
//
//  Created by Anna Ershova on 28.07.2022.
//  Copyright © 2022 orgName. All rights reserved.
//

import SwiftUI
import shared

struct NewsScreen: View {
    @ObservedObject var newsModel = NewsViewModel()
    
    var body: some View {
        List(newsModel.items, id: \.self) { i in
            Text(i.title ?? "no title")
        }
        .onAppear {
            newsModel.loadNews()
        }
    }
}


