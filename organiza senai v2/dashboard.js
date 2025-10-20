const tarefasPorDia = {
    segunda: ["- Exercício de funções", "- Estudar frações", "- Fórmula de Bhaskara", "- Trigonometria"],
    terca: ["- Resumo da Revolução Francesa", "- Gramática", "- Produção de texto", "- Clube de leitura"],
    quarta: ["- Criar um site em HTML", "- Estudar JavaScript", "- Front-end"],
    quinta: ["- Relatório de experimento", "- Ida ao laboratório", "- Campeonato de Vôlei"],
    sexta: ["- Revisar leis de Newton", "- Montagem de robô", "- Verbo to be"]
  };
  
  function verDetalhes(dia) {
    const tarefas = tarefasPorDia[dia] || [];
    alert("📘 Detalhes do dia:\n\n" + tarefas.join("\n"));
  }
  
  const lista = document.getElementById("lista-tarefas");
  const input = document.getElementById("nova-tarefa");
  const btn = document.getElementById("btn-adicionar");
  
  // Mostra tarefas do dia atual
  const dias = ["domingo", "segunda", "terca", "quarta", "quinta", "sexta", "sabado"];
  const hoje = dias[new Date().getDay()];
  const tarefasHoje = tarefasPorDia[hoje] || [];
  
  if (tarefasHoje.length === 0) {
    lista.innerHTML = "<li>Sem tarefas hoje 🎉</li>";
  } else {
    tarefasHoje.forEach(tarefa => {
      const li = document.createElement("li");
      li.textContent = tarefa;
      lista.appendChild(li);
    });
  }
  
  // Adicionar nova tarefa
  btn.addEventListener("click", () => {
    const valor = input.value.trim();
    if (valor) {
      const li = document.createElement("li");
      li.textContent = valor;
      lista.appendChild(li);
      input.value = "";
    }
  });
  