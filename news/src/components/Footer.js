import React from 'react'


export default function Footer({autor = ''}) {
  return (
    <footer className='blog-footer'>
        <p>
            {autor}
        </p>
    </footer>
  )
}
