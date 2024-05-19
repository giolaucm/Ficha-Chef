document.addEventListener("DOMContentLoaded", function() {
    ['nome', 'email', 'assunto', 'pergunta'].forEach(id => {
      const input = document.getElementById(id);
      const label = document.querySelector(`label[for='${id}']`);
  
      input.addEventListener("focus", function() {
        label.classList.add("label-focus");
      });
  
      input.addEventListener("blur", function() {
        label.classList.remove("label-focus");
      });
    });
  });
  
  
  