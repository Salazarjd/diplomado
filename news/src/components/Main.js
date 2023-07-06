import React, { useEffect, useState } from 'react'
import { AUTOR, API_URL, API_COUNTRY } from '../config'
import Footer from './Footer'
import Noticias from './Noticias'
import Header from './Header'


export default function Main() {

  const categories = [
    'business',
    'entertainment',
    'general',
    'health',
    'science',
    'sports',
    'technology'
  ]

  const [ news, setNews] = useState([])

  useEffect( () => {
    getNews()
  }, [])

  const getNews = async(evt) => {
    let category = 'general'
    if(evt != null){
        category = evt.target.value
    }
    const URI = `${API_URL}/top-headlines?country=${API_COUNTRY}&apiKey=${process.env.REACT_APP_API_KEY}&category=${category}`
    // fetch(URI)
    // .then(resp => resp.json())
    // .then(data => {
    //     console.log(data.articles)
    //     setNews(data.articles)
    // })
    // .catch(error => console.log(error))

    try{
      const resp = await fetch(URI)
      const data = await resp.json()
      console.log(data.articles)
      setNews(data.articles)
    }catch(error){
      console.log(error)
    }
  }

  return (
    <div className="container mt-2">
        <Header getNews={getNews} categories={categories}/>
        <Noticias news={news}/>    
        <Footer autor={AUTOR}/>
    </div>
  )
}




