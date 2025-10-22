// ====== BUSCA AS AULAS NA API ======
async function carregarAulas() {
  try {
    const response = await fetch("https://backend-info1.vercel.app/v2/aulas");
    const aulas = await response.json();

    const diasContainer = document.getElementById("aulas-api");
    diasContainer.innerHTML = "";

    if (!Array.isArray(aulas) || aulas.length === 0) {
      diasContainer.innerHTML = "<p>Sem aulas cadastradas 📭</p>";
      return;
    }

    // Agrupa as aulas por data
    const aulasPorData = {};
    aulas.forEach(aula => {
      const data = aula.data || "Sem data";
      if (!aulasPorData[data]) aulasPorData[data] = [];
      aulasPorData[data].push(aula.conteudo);
    });

    // Cria um bloco para cada data
    Object.entries(aulasPorData).forEach(([data, conteudos]) => {
      const divDia = document.createElement("div");
      divDia.classList.add("dia");

      const titulo = document.createElement("h3");
      titulo.textContent = data;
      divDia.appendChild(titulo);

      conteudos.forEach(conteudo => {
        const divMateria = document.createElement("div");
        divMateria.classList.add("materia");
        divMateria.textContent = conteudo;
        divMateria.addEventListener("click", () => verDetalhes(data, conteudo));
        divDia.appendChild(divMateria);
      });

      diasContainer.appendChild(divDia);
    });
  } catch (erro) {
    console.error("Erro ao carregar aulas:", erro);
    const diasContainer = document.getElementById("aulas-api");
    diasContainer.innerHTML = "<p>Erro ao carregar aulas. Tente novamente mais tarde.</p>";
  }
}

// ====== BUSCA AS TAREFAS NA API ======
async function carregarTarefas() {
  try {
    const response = await fetch("https://backend-info1.vercel.app/v2/tarefas");
    const tarefas = await response.json();

    const tarefasFiltradas = tarefas.filter(t => t.ref === "aulas");

    const lista = document.getElementById("lista-tarefas");
    lista.innerHTML = "";

    if (tarefasFiltradas.length === 0) {
      lista.innerHTML = "<li>Sem tarefas no momento 🎉</li>";
      return;
    }

    tarefasFiltradas.forEach(tarefa => {
      const li = document.createElement("li");
      li.textContent = tarefa.nome;
      lista.appendChild(li);
    });
  } catch (erro) {
    console.error("Erro ao carregar tarefas:", erro);
    const lista = document.getElementById("lista-tarefas");
    lista.innerHTML = "<li>Erro ao carregar tarefas.</li>";
  }
}

// ====== DETALHES ======
function verDetalhes(data, conteudo) {
  alert(`📘 Aula do dia ${data}\n\n${conteudo}`);
}

// ====== ADICIONA nova tarefa ======
const input = document.getElementById("nova-tarefa");
const btn = document.getElementById("btn-adicionar");

btn.addEventListener("click", () => {
  const valor = input.value.trim();
  if (valor) {
    const li = document.createElement("li");
    li.textContent = valor;
    document.getElementById("lista-tarefas").appendChild(li);
    input.value = "";
  }
});

// ======carrega as apis ======
carregarAulas();
carregarTarefas();
