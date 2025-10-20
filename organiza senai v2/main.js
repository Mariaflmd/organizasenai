function showLogin() {
  document.getElementById("login-form").classList.remove("hidden");
  document.getElementById("register-form").classList.add("hidden");
  document.getElementById("forgot-password-form").classList.add("hidden");
}

function showRegister() {
  document.getElementById("login-form").classList.add("hidden");
  document.getElementById("register-form").classList.remove("hidden");
  document.getElementById("forgot-password-form").classList.add("hidden");
}

function showForgotPassword() {
  document.getElementById("login-form").classList.add("hidden");
  document.getElementById("register-form").classList.add("hidden");
  document.getElementById("forgot-password-form").classList.remove("hidden");
}

// ---- LOGIN ----
async function login() {
  const email = document.getElementById("login-email").value;
  const password = document.getElementById("login-password").value;
  const mensagem = document.getElementById("mensagem");

  try {
    const response = await fetch("https://backend-info1.vercel.app/login", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ login: email, senha: password })
    });

    const data = await response.json();

    if (response.ok) {
      mensagem.style.color = "green";
      mensagem.innerText = "Login realizado com sucesso!";
      alert(`Bem-vindo, ${data.nome || email}!`);
      window.location.href = "dashboard.html";
    } else {
      mensagem.style.color = "red";
      mensagem.innerText = data.message || "Erro no login. Verifique seus dados.";
    }
  } catch (error) {
    mensagem.style.color = "red";
    mensagem.innerText = "Erro de conexão com o servidor.";
    console.error("Erro no login:", error);
  }
}

// ---- CADASTRO ----
async function register() {
  const name = document.getElementById("register-name").value;
  const email = document.getElementById("register-email").value;
  const password = document.getElementById("register-password").value;

  try {
    const response = await fetch("https://backend-info1.vercel.app/criarLogin", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ login: email, senha: password })
    });

    const data = await response.json();

    if (response.ok) {
      alert("Cadastro realizado com sucesso! Faça login para continuar.");
      showLogin();
    } else {
      alert(data.message || "Erro ao cadastrar. Tente novamente.");
    }
  } catch (error) {
    alert("Erro de conexão com o servidor.");
    console.error("Erro no cadastro:", error);
  }
}

// ---- RECUPERAR SENHA (simulado) ----
function recoverPassword() {
  const email = document.getElementById("forgot-email").value;
  alert(`Instruções de recuperação enviadas para: ${email}`);
}
