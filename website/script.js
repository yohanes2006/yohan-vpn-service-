const reveals=document.querySelectorAll('.reveal');
const observer=new IntersectionObserver(entries=>{entries.forEach(entry=>{if(entry.isIntersecting){entry.target.classList.add('show');observer.unobserve(entry.target)}})},{threshold:.12});
reveals.forEach(el=>observer.observe(el));
const themeBtn=document.getElementById('themeBtn');
themeBtn.addEventListener('click',()=>{document.body.classList.toggle('light');themeBtn.textContent=document.body.classList.contains('light')?'☀':'☾'});
