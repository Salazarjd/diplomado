import React from 'react'
import Noticia from './Noticia'


export default function Noticias({news = []}) {
  return (
    <div className="row row-cols-1 row-cols-md-2 g-4">
    {
        news.map((n,i) => <Noticia key={i} n={n}/>)
    }
    </div>
  )
}
