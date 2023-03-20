import java.awt.Dimension
import javax.swing.*

fun main(args: Array<String>) {
    //MovieRepo.movies.stream().forEach { println(it.title) }
    MainFrame()
}

class MainFrame : JFrame() {
    var panel = MainPanel()
    init{
        //layout = BoxLayout.Y_AXIS
        add(panel)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible  = true
        pack()

        setLocationRelativeTo(null)
    }


}

class MainPanel: JPanel() {

    private val movieViewModel: MovieViewModel = MovieViewModel()
    private val button: JButton = JButton("Get Movie")
    private val m_nameLabel: JLabel = JLabel(" ")

    init{
        // layout = BorderLayout()
        preferredSize = Dimension(500,500)
        add(button)
        add(m_nameLabel)
        initComponents()
    }

    //Initialise Components with their Data Handling
    private fun initComponents() {
        button.addActionListener {
            val movie = movieViewModel.loadMovieData()
            m_nameLabel.text  = movieViewModel.currentMovie?.title ?: "No Movie selected"
            updateLabels(movieViewModel.currentMovie)
        }
        m_nameLabel.text  = movieViewModel.currentMovie?.title ?: "No Movie selected"
    }
    private fun updateLabels(movie: Movie?) {
        m_nameLabel.text = movie?.title ?: "${movie?.title}"
    }
}