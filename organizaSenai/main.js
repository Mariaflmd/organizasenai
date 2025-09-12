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

function login() {
  const email = document.getElementById("login-email").value;
  const password = document.getElementById("login-password").value;
  const senhaCorreta = "minhasenha123";

  if (password === senhaCorreta) {
    document.getElementById('mensagem').style.color = 'green';
    document.getElementById('mensagem').innerText = 'Login bem-sucedido!';
    alert(`Login feito com sucesso!\nEmail: ${email}`);
    window.location.href = "dashboard.html"; // 👉 Redireciona para a nova página
  } else {
    document.getElementById('mensagem').style.color = 'red';
    document.getElementById('mensagem').innerText = 'Senha incorreta. Tente novamente.';
    alert(`Senha incorreta para:\nEmail: ${email}`);
  }
}

function register() {
  const name = document.getElementById("register-name").value;
  const email = document.getElementById("register-email").value;
  const password = document.getElementById("register-password").value;
  alert(`Cadastro:\nNome: ${name}\nEmail: ${email}\nSenha: ${password}`);
}

function recoverPassword() {
  const email = document.getElementById("forgot-email").value;
  alert(`Instruções de recuperação enviadas para: ${email}`);
}
