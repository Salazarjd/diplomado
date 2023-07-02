import React from 'react'


export default function Noticia({n}) {
  return (
    <div className="col">
        <div className="card">
        <img src={n.urlToImage} className="card-img-top" alt=""/>
        <div className="card-body">
            <h5 className="card-title">{n.title}</h5>
            <p className="card-text">
                <a href={n.url} target={'_blank'}>{n.author}</a>
            </p>
        </div>
        </div>
    </div>
  )
}
