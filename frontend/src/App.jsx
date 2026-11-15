import { useState } from 'react'

function App() {
  const [id, setId] = useState('')
  const [password, setPassword] = useState('')
  const [message, setMessage] = useState('')

  async function handleLogin(e){
    e.preventDefault()

    try{
      const response = await fetch('http://localhost:8080/auth/signin',{
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({id, password})
      })

      if(!response.ok){
        setMessage('아이디 또는 비밀번호가 틀렸습니다')
        return
      }
      const data = await response.json()
      localStorage.setItem('token', data.token)
      setMessage(`${data.username}님 환영합니다`)
    }catch(error){
      console.error(error)
      setMessage('서버에 연결할 수 없습니다')
    }
  }

  return (
      <form onSubmit={handleLogin}>
        <h1>로그인</h1>

        <div>
          <label>아이디 </label>
          <input value={id} onChange={(e) => setId(e.target.value)} />
        </div>

        <div>
          <label>비밀번호 </label>
          <input
              type="password"
              value={password}
              onChange={(e) => setPassword(e.target.value)}
          />
        </div>

        <button type="submit">로그인</button>

        <p>{message}</p>
      </form>
  )
}

export default App
