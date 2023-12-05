package com.example.fichachefapp.ui.activity

import androidx.fragment.app.Fragment

class CustoAdiciona : Fragment() {
    /*@SuppressLint("MissingInflatedId")
    private var _binding: FragmentCustoAdicionaBinding? = null
    private val binding get() = _binding!!

    private val dao = CustoDao()
    private lateinit var adapter: ListaCustoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCustoAdicionaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ListaCustoAdapter(context = requireContext(), custos = dao.buscaTodos())
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.floatingActionButton
        fab.setOnClickListener {
            vaiParaFormulario()
        }
    }

    private fun vaiParaFormulario() {
        val intent = Intent(requireContext(), Formulario::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.recyclerView
        recyclerView.adapter = adapter

        recyclerView.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                if (e.action == MotionEvent.ACTION_UP) {
                    val item = recyclerView.findChildViewUnder(e.x, e.y)
                    val position = recyclerView.getChildAdapterPosition(item!!)
                    val custo = adapter.getItem(position)
                    exibirAlerta(custo)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {}

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {}
        })
    }

    private fun exibirAlerta(custo: Custo) {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Excluir item")
        builder.setMessage("Deseja excluir o item selecionado?")
        builder.setPositiveButton("Sim") { dialog, _ ->
            dao.removeCusto(custo)
            adapter.atualiza(dao.buscaTodos())
            dialog.dismiss()
        }
        builder.setNegativeButton("Não") { dialog, _ ->
            dialog.dismiss()
        }
        builder.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }*/
}