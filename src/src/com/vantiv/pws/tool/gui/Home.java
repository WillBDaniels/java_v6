/**
Copyright (c) 2014 Vantiv, Inc. - All Rights Reserved.
Sample Code is for reference only and is solely intended to be used for educational purposes and is provided “AS IS” and “AS AVAILABLE” and without warranty. It is the responsibility of the developer to  develop and write its own code before successfully certifying their solution.  
This sample may not, in whole or in part, be copied, photocopied, reproduced, translated, or reduced to any electronic medium or machine-readable form without prior consent, in writing, from Vantiv, Inc.
Use, duplication or disclosure by the U.S. Government is subject to restrictions set forth in an executed license agreement and in subparagraph (c)(1) of the Commercial Computer Software-Restricted Rights Clause at FAR 52.227-19; subparagraph (c)(1)(ii) of the Rights in Technical Data and Computer Software clause at DFARS 252.227-7013, subparagraph (d) of the Commercial Computer Software--Licensing clause at NASA FAR supplement 16-52.227-86; or their equivalent.
Information in this sample code is subject to change without notice and does not represent a commitment on the part of Vantiv, Inc.  In addition to the foregoing, the Sample Code is subject to the terms and conditions set forth in the Vantiv Terms and Conditions of Use (http://www.apideveloper.vantiv.com) and the Vantiv Privacy Notice (http://www.vantiv.com/Privacy-Notice).  
 **/

/*  
 * GUI class to send soap requests to PWS. All values set
 * in this class are sent to the DataStore class. The soap
 * message is then constructed from those values. 
 * 
 * */
package com.vantiv.pws.tool.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.vantiv.pws.soap.objects.DataStore;
import com.vantiv.pws.soap.objects.Driver;
import com.vantiv.pws.soap.objects.InitializeClient;
import com.vantiv.pws.soap.objects.Utils;
import com.vantiv.types.payment.transactions.v6.BatchResponseType;
import com.vantiv.types.payment.transactions.v6.TokenizationResultType;
import com.vantiv.types.payment.transactions.v6.TransactionResponseType;

/**
 * GUI was created with Eclipse Window Builder. This GUI can be used to
 * send/receive SOAP requests directly to PWS. There is no logic in this code.
 * For logic and to see how the messages are built and sent, please refer to
 * either com.vantiv.pws.soap.objects for SOAP logic, or
 * com.vantiv.pws.apigee.objects for JSON/apigee logic.
 */
public class Home extends JFrame {

	private JPanel contentPane;
	private DataStore globals;
	private Utils util = new Utils();
	private Driver driver;

	private JTextField wsdlLocTxt;
	private JTextField userNameTxt;
	private JTextField passTxt;
	private InitializeClient client;

	private JTextField textField_TransAmt;
	private JTextField textField_SystemTraceID;
	private JTextField textField_ReferenceNum;
	private JTextField textField_ReportGrp;

	private JTextField textField_CashierNum;
	private JTextField textField_ChainCode;
	private JTextField textField_ClerkNum;
	private JTextField textField_DivisionNum;
	private JTextField textField_LaneNum;
	private JTextField textField_MerchantID;
	private JTextField textField_MerchantName;
	private JTextField textField_StoreNum;
	private JTextField textField_NetworkRouting;

	private JTextField textField_TerminalID;
	private JTextField textField_SequenceNum;
	private JTextField textField_IPv4;
	private JTextField textField_Longitude;
	private JTextField textField_Latitude;
	private JTextField textField_CardSecCode;
	private JTextField textField_CardHolderName;
	private JTextField textField_GiftCardPin;
	private JTextField textField_GiftCardSecCode;
	private JTextField textField_AcctType;
	private JTextField textField_Track1;
	private JTextField textField_Track2;
	private JTextField textField_PAN;
	private JTextField textField_EncryptedPAN;
	private JTextField textField_ExpirationDate;
	private JTextField textField_RequestResult;

	private JTextField textField_AddressLine;
	private JTextField textField_City;
	private JTextField textField__State;
	private JTextField textField_PostalCode;
	private JTextField textField_AuthorizationCode;
	private JTextField txt_AddressVerificationCode;
	private JTextField txt_AddressVerificationType;
	private JTextField txt_CardSecCode;
	private JTextField txt_CardSecurityCodeType;
	private JTextField textField_TransactionId;
	private JTextField textField_ValidationCode;
	private JTextField textField_NetworkResponseCode;
	private JTextField textField_SettlementAmt;
	private JTextField textField_TipAmount;
	private JTextField textField_PurchaseOrder;
	private JTextField textField_ConvenienceFee;
	private JTextField textField_OrigAuthorizationCode;
	private JTextField textField_ReplacementAmt;

	final JComboBox comboBox_PartialIndicator;
	final JComboBox comboBox_RequestType;
	final JComboBox comboBox_TransType;
	final JComboBox comboBox_PaymentType;
	final JComboBox comboBox_CaptureDevice;
	final JComboBox comboBox_EntryMode;
	final JComboBox comboBox_PinEntry;
	final JComboBox comboBox_Classification;
	final JComboBox comboBox_CardReader;
	final JComboBox comboBox_BalanceEnquiry;
	final JComboBox comboBox_HostAdj;
	final JComboBox comboBox_CardType;
	final JComboBox comboBox_CancelType;
	final JComboBox comboBox_ReversalReason;

	public static JTextArea textArea_Results;
	public static JTextArea textArea_TestScriptLog;

	final JRadioButton radioButton_CardSwiped;
	final JRadioButton radioButton_CardKeyed;

	final JRadioButton rdbtnSendToApigee;
	final JRadioButton rdbtnTokenRequested;


	private JTextField textField_ReferenceNumber;
	private JTextField textField_OriginalReferenceNum;

	private JTextField textField_AdjustmentAmount;
	private JTextField textField_DeclineCode;
	private JTextField textField_DeclineMessage;
	private JTable table;
	private JTextField textField_RefundAmt;
	private JTextField textField_Endpoint;
	private JTextField textField_PinData;
	private JTextField textField_TokenResult;
	private JTextField textField_TokenId;
	private JTextField textField_TokenValue;
	private JTextField textField_tokenId;
	private JTextField textField_tokenValue;

	final JPanel panel_CardSwiped;
	final JPanel panel_CardKeyed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame. JFrame consists of 5 Tabs. The "Main" tab contains
	 * values for: username/pass, wsdl location, request Type, and also a
	 * JTextArea that outputs the Logs of the soap request. The "Transaction"
	 * tab contains the values for: Transaction Amount, SystemTraceID, Payment
	 * Type, Transaction Type, Reference Number, and report group. The
	 * "Merchant Data" tab contains values for: Cashier Number, Chain code,
	 * Division number, lane number, Merchant ID, Merchant Name, Store Number,
	 * Network Routing, and Capture Device. The "Capture Device" tab contains
	 * values for: Terminal ID, Sequence Number, Entry mode, Pin Entry, IP4
	 * Address, Classification, Card Reader, Balance Enquiry, Host Adjustment,
	 * and Longitude/Latitude (mobile only). The "Card Data" tab contains the
	 * values for: Primary Account Number, Encrypted Primary Account Number,
	 * Expiration Date, Card Type, Partial Indicator, Card Security Code, Card
	 * Holder Name, Gift card pin, Gift Card security code, Accout Type, and
	 * address information.
	 */
	public Home() {
		client = new InitializeClient();
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e1) {
		}
		globals = new DataStore();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 616);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(SwingConstants.TOP);
		tabbedPane.setBounds(0, 0, 684, 578);
		contentPane.add(tabbedPane);

		// ******************MAIN TAB*********************//
		JPanel panel_Main = new JPanel();
		tabbedPane.addTab("Main", null, panel_Main, null);
		tabbedPane.setEnabledAt(0, true);
		panel_Main.setLayout(null);

		JLabel lblWsdlLocation = new JLabel("Wsdl Location");
		lblWsdlLocation.setBounds(10, 11, 86, 14);
		panel_Main.add(lblWsdlLocation);

		JLabel lblUsername = new JLabel("UserName");
		lblUsername.setBounds(10, 36, 86, 14);
		panel_Main.add(lblUsername);

		JLabel lblPasswored = new JLabel("Password");
		lblPasswored.setBounds(10, 61, 86, 14);
		panel_Main.add(lblPasswored);

		wsdlLocTxt = new JTextField();
		wsdlLocTxt.setBounds(106, 8, 158, 20);
		wsdlLocTxt.setText(client.getWsdlLocation());
		panel_Main.add(wsdlLocTxt);
		wsdlLocTxt.setColumns(10);

		userNameTxt = new JTextField();
		userNameTxt.setBounds(106, 33, 158, 20);
		userNameTxt.setColumns(10);
		userNameTxt.setText(client.getUser());
		panel_Main.add(userNameTxt);

		passTxt = new JTextField();
		passTxt.setBounds(106, 58, 158, 20);
		passTxt.setText(client.getPass());
		passTxt.setColumns(10);
		panel_Main.add(passTxt);

		comboBox_RequestType = new JComboBox();
		comboBox_RequestType.setBounds(106, 118, 158, 20);
		comboBox_RequestType.setModel(new DefaultComboBoxModel(new String[] {
				"Authorize", "Purchase", "Capture", "Activate", "Adjust",
				"BalanceInquiry", "BatchBalance", "Cancel", "Close",
				"CloseBatch", "Echo", "Refund", "Reload", "Tokenize", "Unload",
				"UpdateCard" }));
		panel_Main.add(comboBox_RequestType);

		JLabel lblRequestType = new JLabel("Request Type");
		lblRequestType.setBounds(10, 115, 86, 14);
		panel_Main.add(lblRequestType);

		JLabel lblRequestResult = new JLabel("Request Result:");
		lblRequestResult.setBounds(304, 40, 89, 14);
		panel_Main.add(lblRequestResult);

		textField_RequestResult = new JTextField();
		textField_RequestResult.setBounds(423, 37, 100, 20);
		textField_RequestResult.setEditable(false);
		textField_RequestResult.setColumns(10);
		panel_Main.add(textField_RequestResult);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 414, 659, 125);
		panel_Main.add(scrollPane);

		textArea_Results = new JTextArea();
		textArea_Results.setFont(new Font("Monospaced", Font.PLAIN, 11));
		textArea_Results.setEditable(false);
		scrollPane.setViewportView(textArea_Results);

		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(10, 389, 46, 14);
		panel_Main.add(lblLog);

		JLabel lblAuthorizationCode = new JLabel("Authorization Code:");
		lblAuthorizationCode.setBounds(304, 65, 106, 14);
		panel_Main.add(lblAuthorizationCode);

		textField_AuthorizationCode = new JTextField();
		textField_AuthorizationCode.setEditable(false);
		textField_AuthorizationCode.setColumns(10);
		textField_AuthorizationCode.setBounds(423, 62, 100, 20);
		panel_Main.add(textField_AuthorizationCode);

		JLabel lblAddressVerification = new JLabel("Address Verification:");
		lblAddressVerification.setBounds(304, 90, 106, 14);
		panel_Main.add(lblAddressVerification);

		txt_AddressVerificationCode = new JTextField();
		txt_AddressVerificationCode.setText("Code");
		txt_AddressVerificationCode.setEditable(false);
		txt_AddressVerificationCode.setColumns(10);
		txt_AddressVerificationCode.setBounds(423, 87, 100, 20);
		panel_Main.add(txt_AddressVerificationCode);

		txt_AddressVerificationType = new JTextField();
		txt_AddressVerificationType.setText("Type");
		txt_AddressVerificationType.setEditable(false);
		txt_AddressVerificationType.setColumns(10);
		txt_AddressVerificationType.setBounds(529, 87, 140, 20);
		panel_Main.add(txt_AddressVerificationType);

		JLabel lblCardSecurityCode = new JLabel("Card Security Code:");
		lblCardSecurityCode.setBounds(304, 115, 106, 14);
		panel_Main.add(lblCardSecurityCode);

		txt_CardSecCode = new JTextField();
		txt_CardSecCode.setText("Code");
		txt_CardSecCode.setEditable(false);
		txt_CardSecCode.setColumns(10);
		txt_CardSecCode.setBounds(423, 112, 100, 20);
		panel_Main.add(txt_CardSecCode);

		txt_CardSecurityCodeType = new JTextField();
		txt_CardSecurityCodeType.setText("Type");
		txt_CardSecurityCodeType.setEditable(false);
		txt_CardSecurityCodeType.setColumns(10);
		txt_CardSecurityCodeType.setBounds(530, 112, 139, 20);
		panel_Main.add(txt_CardSecurityCodeType);

		JLabel lblPaymentServiceResults = new JLabel(
				"-Payment Service Results-");
		lblPaymentServiceResults.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPaymentServiceResults.setBounds(423, 137, 165, 14);
		panel_Main.add(lblPaymentServiceResults);

		JLabel lblTransactionId = new JLabel("Transaction Id:");
		lblTransactionId.setBounds(304, 165, 106, 14);
		panel_Main.add(lblTransactionId);

		JLabel lblValidationCode = new JLabel("Validation Code:");
		lblValidationCode.setBounds(304, 190, 106, 14);
		panel_Main.add(lblValidationCode);

		textField_TransactionId = new JTextField();
		textField_TransactionId.setText("Code");
		textField_TransactionId.setEditable(false);
		textField_TransactionId.setColumns(10);
		textField_TransactionId.setBounds(423, 162, 100, 20);
		panel_Main.add(textField_TransactionId);

		textField_ValidationCode = new JTextField();
		textField_ValidationCode.setText("Code");
		textField_ValidationCode.setEditable(false);
		textField_ValidationCode.setColumns(10);
		textField_ValidationCode.setBounds(423, 187, 100, 20);
		panel_Main.add(textField_ValidationCode);

		JLabel lblNewLabel_1 = new JLabel("-Request Results-");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(423, 11, 140, 14);
		panel_Main.add(lblNewLabel_1);

		// ************ SEND SOAP BUTTON ************* //
		JButton btnSendSoap = new JButton("Send Soap");
		btnSendSoap.setBounds(177, 149, 89, 23);
		panel_Main.add(btnSendSoap);

		JLabel lblTransactionTimestamp = new JLabel("Reference Number:");
		lblTransactionTimestamp.setBounds(304, 215, 121, 14);
		panel_Main.add(lblTransactionTimestamp);

		textField_ReferenceNumber = new JTextField();
		textField_ReferenceNumber.setEditable(false);
		textField_ReferenceNumber.setColumns(10);
		textField_ReferenceNumber.setBounds(423, 212, 100, 20);
		panel_Main.add(textField_ReferenceNumber);

		JLabel lblDeclineCode = new JLabel("Decline Code:");
		lblDeclineCode.setBounds(10, 194, 72, 14);
		panel_Main.add(lblDeclineCode);

		JLabel lblDeclineMessage = new JLabel("Decline Message:");
		lblDeclineMessage.setBounds(10, 219, 89, 14);
		panel_Main.add(lblDeclineMessage);

		textField_DeclineCode = new JTextField();
		textField_DeclineCode.setEditable(false);
		textField_DeclineCode.setColumns(10);
		textField_DeclineCode.setBounds(95, 191, 100, 20);
		panel_Main.add(textField_DeclineCode);

		textField_DeclineMessage = new JTextField();
		textField_DeclineMessage.setEditable(false);
		textField_DeclineMessage.setColumns(10);
		textField_DeclineMessage.setBounds(95, 216, 169, 20);
		panel_Main.add(textField_DeclineMessage);

		JLabel lblEndPoint = new JLabel("End Point");
		lblEndPoint.setBounds(10, 86, 86, 14);
		panel_Main.add(lblEndPoint);

		textField_Endpoint = new JTextField();
		textField_Endpoint.setColumns(10);
		textField_Endpoint.setText(client.getEndpoint());
		textField_Endpoint.setBounds(106, 84, 158, 20);
		panel_Main.add(textField_Endpoint);

		rdbtnSendToApigee = new JRadioButton("Send to Apigee?");
		rdbtnSendToApigee.setBounds(6, 145, 109, 23);
		panel_Main.add(rdbtnSendToApigee);

		JLabel lblTokenizeResult = new JLabel("-Tokenize Result-");
		lblTokenizeResult.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTokenizeResult.setBounds(423, 243, 106, 14);
		panel_Main.add(lblTokenizeResult);

		JLabel lblResult = new JLabel("Result:");
		lblResult.setBounds(304, 260, 64, 14);
		panel_Main.add(lblResult);

		JLabel lblTokenId = new JLabel("Token ID:");
		lblTokenId.setBounds(304, 285, 64, 14);
		panel_Main.add(lblTokenId);

		JLabel lblTokenValue = new JLabel("Token Value:");
		lblTokenValue.setBounds(304, 310, 72, 14);
		panel_Main.add(lblTokenValue);

		textField_TokenResult = new JTextField();
		textField_TokenResult.setEditable(false);
		textField_TokenResult.setColumns(10);
		textField_TokenResult.setBounds(378, 257, 145, 20);
		panel_Main.add(textField_TokenResult);

		textField_TokenId = new JTextField();
		textField_TokenId.setEditable(false);
		textField_TokenId.setColumns(10);
		textField_TokenId.setBounds(378, 282, 145, 20);
		panel_Main.add(textField_TokenId);

		textField_TokenValue = new JTextField();
		textField_TokenValue.setEditable(false);
		textField_TokenValue.setColumns(10);
		textField_TokenValue.setBounds(378, 307, 145, 20);
		panel_Main.add(textField_TokenValue);

		btnSendSoap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendSoap();
			}
		});

		// ***************************************************************//

		// ****************** TRANSACTION DATA TAB ************************ //
		JPanel panel_Transaction = new JPanel();
		tabbedPane.addTab("Transaction Data", null, panel_Transaction, null);
		panel_Transaction.setLayout(null);

		JLabel label_Transaction = new JLabel("Payment Type");
		label_Transaction.setBounds(10, 14, 102, 20);
		panel_Transaction.add(label_Transaction);

		JLabel lblTransactionAmountoriginal = new JLabel(
				"Transaction Amount (Original)");
		lblTransactionAmountoriginal.setBounds(10, 45, 144, 20);
		panel_Transaction.add(lblTransactionAmountoriginal);

		JLabel label_Transaction_2 = new JLabel("Transaction Type");
		label_Transaction_2.setBounds(10, 76, 124, 20);
		panel_Transaction.add(label_Transaction_2);

		JLabel label_Transaction_3 = new JLabel("System Trace ID");
		label_Transaction_3.setBounds(10, 107, 124, 20);
		panel_Transaction.add(label_Transaction_3);

		JLabel label_Transaction_4 = new JLabel("Reference Number");
		label_Transaction_4.setBounds(10, 138, 124, 20);
		panel_Transaction.add(label_Transaction_4);

		JLabel label_Transaction_5 = new JLabel("Report Group");
		label_Transaction_5.setBounds(10, 169, 124, 20);
		panel_Transaction.add(label_Transaction_5);

		textField_TransAmt = new JTextField();
		textField_TransAmt.setText("$" + globals.getTransactionAmount());
		textField_TransAmt.setColumns(10);
		textField_TransAmt.setBounds(164, 45, 124, 20);
		panel_Transaction.add(textField_TransAmt);

		textField_SystemTraceID = new JTextField();
		textField_SystemTraceID.setText("" + globals.getSystemTraceId());
		textField_SystemTraceID.setColumns(10);
		textField_SystemTraceID.setBounds(164, 107, 124, 20);
		panel_Transaction.add(textField_SystemTraceID);

		textField_ReferenceNum = new JTextField();
		textField_ReferenceNum.setText(globals.getReferenceNumber());
		textField_ReferenceNum.setColumns(10);
		textField_ReferenceNum.setBounds(164, 138, 124, 20);
		panel_Transaction.add(textField_ReferenceNum);

		textField_ReportGrp = new JTextField();
		textField_ReportGrp.setText(globals.getReportGroup());
		textField_ReportGrp.setColumns(10);
		textField_ReportGrp.setBounds(164, 169, 124, 20);
		panel_Transaction.add(textField_ReportGrp);

		comboBox_TransType = new JComboBox();
		comboBox_TransType.setModel(new DefaultComboBoxModel(new String[] {
				"present", "ecommerce", "moto" }));
		comboBox_TransType.setBounds(164, 76, 124, 20);
		panel_Transaction.add(comboBox_TransType);

		comboBox_PaymentType = new JComboBox();
		comboBox_PaymentType.setModel(new DefaultComboBoxModel(
				new String[] { "single", "recurring", "installment", "billpay",
						"resubmission" }));
		comboBox_PaymentType.setBounds(164, 14, 124, 20);
		panel_Transaction.add(comboBox_PaymentType);

		JLabel lblNetworkResponseCode = new JLabel("Network Response Code");
		lblNetworkResponseCode.setBounds(10, 200, 124, 20);
		panel_Transaction.add(lblNetworkResponseCode);

		textField_NetworkResponseCode = new JTextField();
		textField_NetworkResponseCode.setText(globals.getNetworkResponseCode());
		textField_NetworkResponseCode.setColumns(10);
		textField_NetworkResponseCode.setBounds(164, 200, 124, 20);
		panel_Transaction.add(textField_NetworkResponseCode);

		JLabel lblSettlementamount = new JLabel("Settlement Amount");
		lblSettlementamount.setBounds(340, 70, 102, 20);
		panel_Transaction.add(lblSettlementamount);

		textField_SettlementAmt = new JTextField();
		textField_SettlementAmt.setText("$0.00");
		textField_SettlementAmt.setColumns(10);
		textField_SettlementAmt.setBounds(452, 70, 124, 20);
		panel_Transaction.add(textField_SettlementAmt);

		JLabel lblCaptureOnly = new JLabel("- Capture -");
		lblCaptureOnly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCaptureOnly.setBounds(377, 42, 102, 20);
		panel_Transaction.add(lblCaptureOnly);

		JLabel lblOriginalRefNumber = new JLabel("Tip Amount");
		lblOriginalRefNumber.setBounds(340, 101, 102, 20);
		panel_Transaction.add(lblOriginalRefNumber);

		textField_TipAmount = new JTextField();
		textField_TipAmount.setText("$0.00");
		textField_TipAmount.setColumns(10);
		textField_TipAmount.setBounds(452, 101, 124, 20);
		panel_Transaction.add(textField_TipAmount);

		JLabel lblPurchaseOrder = new JLabel("Purchase Order");
		lblPurchaseOrder.setBounds(10, 231, 124, 20);
		panel_Transaction.add(lblPurchaseOrder);

		textField_PurchaseOrder = new JTextField();
		textField_PurchaseOrder.setText(globals.getPurchaseOrder());
		textField_PurchaseOrder.setColumns(10);
		textField_PurchaseOrder.setBounds(164, 231, 124, 20);
		panel_Transaction.add(textField_PurchaseOrder);

		JLabel lblConvenienceFee = new JLabel("Convenience Fee");
		lblConvenienceFee.setBounds(340, 135, 102, 20);
		panel_Transaction.add(lblConvenienceFee);

		textField_ConvenienceFee = new JTextField();
		textField_ConvenienceFee.setText("$0.00");
		textField_ConvenienceFee.setColumns(10);
		textField_ConvenienceFee.setBounds(452, 132, 124, 20);
		panel_Transaction.add(textField_ConvenienceFee);

		JLabel lblAuthorizationCode_1 = new JLabel("Authorization Code");
		lblAuthorizationCode_1.setBounds(340, 14, 102, 20);
		panel_Transaction.add(lblAuthorizationCode_1);

		textField_OrigAuthorizationCode = new JTextField();
		textField_OrigAuthorizationCode.setText(globals.getAuthorizationCode());
		textField_OrigAuthorizationCode.setColumns(10);
		textField_OrigAuthorizationCode.setBounds(452, 11, 124, 20);
		panel_Transaction.add(textField_OrigAuthorizationCode);

		JButton button_Transaction = new JButton("Apply Values");
		button_Transaction.setBounds(36, 444, 124, 23);
		panel_Transaction.add(button_Transaction);

		JLabel lblCancelType = new JLabel("Cancel Type");
		lblCancelType.setBounds(332, 200, 102, 20);
		panel_Transaction.add(lblCancelType);

		comboBox_CancelType = new JComboBox();
		comboBox_CancelType
				.setModel(new DefaultComboBoxModel(new String[] { "authorize",
						"purchase", "purchase_cashback", "refund", "adjust",
						"capture", "activate", "reload", "unload", "close" }));
		comboBox_CancelType.setBounds(443, 200, 125, 20);
		panel_Transaction.add(comboBox_CancelType);

		JLabel lblCancelOnly = new JLabel("- Cancel -");
		lblCancelOnly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCancelOnly.setBounds(369, 169, 102, 20);
		panel_Transaction.add(lblCancelOnly);

		JLabel lblReplacementAmount = new JLabel("Replacement Amount");
		lblReplacementAmount.setBounds(332, 231, 102, 20);
		panel_Transaction.add(lblReplacementAmount);

		textField_ReplacementAmt = new JTextField();
		textField_ReplacementAmt.setText("$0.00");
		textField_ReplacementAmt.setColumns(10);
		textField_ReplacementAmt.setBounds(444, 231, 124, 20);
		panel_Transaction.add(textField_ReplacementAmt);

		JLabel lblReplacementReason = new JLabel("Reversal Reason");
		lblReplacementReason.setBounds(332, 262, 102, 20);
		panel_Transaction.add(lblReplacementReason);

		comboBox_ReversalReason = new JComboBox();
		comboBox_ReversalReason.setModel(new DefaultComboBoxModel(new String[] {
				"INCOMPLETE_TRANSACTION", "TIME_OUT", "INVALID_RESPONSE",
				"DESTINATION_NOT_AVAILABLE", "CLERK_CANCELED_TRANSACTION",
				"CUSTOMER_CANCELED_TRANSACTION", "MISDISPENSE",
				"HARDWARE_FAILURE", "SUSPECTED_FRAUDE" }));
		comboBox_ReversalReason.setBounds(443, 262, 200, 20);
		panel_Transaction.add(comboBox_ReversalReason);

		JLabel lblOriginalTimestamp = new JLabel("Original ReferenceNum");
		lblOriginalTimestamp.setBounds(332, 293, 110, 20);
		panel_Transaction.add(lblOriginalTimestamp);

		textField_OriginalReferenceNum = new JTextField();
		textField_OriginalReferenceNum.setColumns(10);
		textField_OriginalReferenceNum.setBounds(444, 293, 124, 20);
		panel_Transaction.add(textField_OriginalReferenceNum);

		JLabel lblAdjustOnly = new JLabel("- Adjust -");
		lblAdjustOnly.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAdjustOnly.setBounds(377, 324, 102, 20);
		panel_Transaction.add(lblAdjustOnly);

		JLabel lblAdjustmentAmount = new JLabel("Adjustment Amount");
		lblAdjustmentAmount.setBounds(340, 355, 102, 14);
		panel_Transaction.add(lblAdjustmentAmount);

		textField_AdjustmentAmount = new JTextField();
		textField_AdjustmentAmount.setText("$0.00");
		textField_AdjustmentAmount.setColumns(10);
		textField_AdjustmentAmount.setBounds(452, 352, 124, 20);
		panel_Transaction.add(textField_AdjustmentAmount);

		JLabel lblRefund = new JLabel("- Refund -");
		lblRefund.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRefund.setBounds(377, 380, 102, 20);
		panel_Transaction.add(lblRefund);

		JLabel lblRefndAmount = new JLabel("Refund Amount");
		lblRefndAmount.setBounds(340, 411, 102, 14);
		panel_Transaction.add(lblRefndAmount);

		textField_RefundAmt = new JTextField();
		textField_RefundAmt.setText("$0.00");
		textField_RefundAmt.setColumns(10);
		textField_RefundAmt.setBounds(452, 408, 124, 20);
		panel_Transaction.add(textField_RefundAmt);

		rdbtnTokenRequested = new JRadioButton("Token Requested?");
		rdbtnTokenRequested.setBounds(6, 258, 124, 23);
		panel_Transaction.add(rdbtnTokenRequested);
		// **************** Apply Values Button *****************//
		button_Transaction.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyTransactionData();
			}
		});

		// ***************************************************************//

		// ***********************MERCHANT TAB*************************//
		JPanel panel_Merchant = new JPanel();
		panel_Merchant.setLayout(null);
		panel_Merchant.setBorder(new EmptyBorder(5, 5, 5, 5));
		tabbedPane.addTab("Merchant Data", null, panel_Merchant, null);

		JLabel label_12 = new JLabel("Cashier Number");
		label_12.setBounds(69, 38, 91, 14);
		panel_Merchant.add(label_12);

		JLabel label_13 = new JLabel("Chain Code");
		label_13.setBounds(69, 63, 91, 14);
		panel_Merchant.add(label_13);

		JLabel label_14 = new JLabel("Clerk Number");
		label_14.setBounds(69, 88, 91, 14);
		panel_Merchant.add(label_14);

		JLabel label_15 = new JLabel("Division Number");
		label_15.setBounds(69, 113, 91, 14);
		panel_Merchant.add(label_15);

		JLabel label_16 = new JLabel("Lane Number");
		label_16.setBounds(69, 138, 91, 14);
		panel_Merchant.add(label_16);

		JLabel label_17 = new JLabel("Merchant ID");
		label_17.setBounds(69, 161, 91, 14);
		panel_Merchant.add(label_17);

		JLabel label_18 = new JLabel("Merchant Name");
		label_18.setBounds(69, 186, 91, 14);
		panel_Merchant.add(label_18);

		JLabel label_19 = new JLabel("Store Number");
		label_19.setBounds(69, 211, 91, 14);
		panel_Merchant.add(label_19);

		JLabel label_20 = new JLabel("Network Routing");
		label_20.setBounds(69, 236, 91, 14);
		panel_Merchant.add(label_20);

		textField_CashierNum = new JTextField();
		textField_CashierNum.setText("0");
		textField_CashierNum.setColumns(10);
		textField_CashierNum.setBounds(184, 35, 127, 20);
		panel_Merchant.add(textField_CashierNum);

		textField_ChainCode = new JTextField();
		textField_ChainCode.setText(globals.getChainCode());
		textField_ChainCode.setColumns(10);
		textField_ChainCode.setBounds(184, 60, 127, 20);
		panel_Merchant.add(textField_ChainCode);

		textField_ClerkNum = new JTextField();
		textField_ClerkNum.setText("" + globals.getClerkNumber());
		textField_ClerkNum.setColumns(10);
		textField_ClerkNum.setBounds(184, 85, 127, 20);
		panel_Merchant.add(textField_ClerkNum);

		textField_DivisionNum = new JTextField();
		textField_DivisionNum.setText(globals.getDivisionNumber());
		textField_DivisionNum.setColumns(10);
		textField_DivisionNum.setBounds(184, 110, 127, 20);
		panel_Merchant.add(textField_DivisionNum);

		textField_LaneNum = new JTextField();
		textField_LaneNum.setText(globals.getLaneNumber());
		textField_LaneNum.setColumns(10);
		textField_LaneNum.setBounds(184, 135, 127, 20);
		panel_Merchant.add(textField_LaneNum);

		textField_MerchantID = new JTextField();
		textField_MerchantID.setText(globals.getMerchantId());
		textField_MerchantID.setColumns(10);
		textField_MerchantID.setBounds(184, 158, 127, 20);
		panel_Merchant.add(textField_MerchantID);

		textField_MerchantName = new JTextField();
		textField_MerchantName.setText(globals.getMerchantName());
		textField_MerchantName.setColumns(10);
		textField_MerchantName.setBounds(184, 183, 127, 20);
		panel_Merchant.add(textField_MerchantName);

		textField_StoreNum = new JTextField();
		textField_StoreNum.setText(globals.getStoreNumber());
		textField_StoreNum.setColumns(10);
		textField_StoreNum.setBounds(184, 208, 127, 20);
		panel_Merchant.add(textField_StoreNum);

		textField_NetworkRouting = new JTextField();
		textField_NetworkRouting.setText(globals.getNetworkRouting());
		textField_NetworkRouting.setColumns(10);
		textField_NetworkRouting.setBounds(184, 233, 127, 20);
		panel_Merchant.add(textField_NetworkRouting);

		comboBox_CaptureDevice = new JComboBox();
		comboBox_CaptureDevice.setBounds(184, 258, 127, 20);
		comboBox_CaptureDevice.setModel(new DefaultComboBoxModel(new String[] {
				"software", "terminal", "mobile" }));
		panel_Merchant.add(comboBox_CaptureDevice);

		JLabel label_21 = new JLabel("Capture Device");
		label_21.setBounds(69, 261, 91, 14);
		panel_Merchant.add(label_21);

		// ****************APPLY VALUES BUTTON*****************//
		JButton button_1 = new JButton("Apply Values");
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyMerchantValues();
			}
		});
		button_1.setBounds(184, 308, 127, 23);
		panel_Merchant.add(button_1);
		// ***************************************************************//

		// ************************CAPTURE DEVICE TAB***********************//
		JPanel panel_Capture = new JPanel();
		panel_Capture.setLayout(null);
		tabbedPane.addTab("Capture Device Data", null, panel_Capture, null);

		JLabel label_28 = new JLabel("Terminal ID");
		label_28.setBounds(44, 28, 98, 14);
		panel_Capture.add(label_28);

		JLabel label_29 = new JLabel("Sequence Number");
		label_29.setBounds(44, 53, 98, 14);
		panel_Capture.add(label_29);

		JLabel label_30 = new JLabel("Entry Mode");
		label_30.setBounds(44, 78, 98, 14);
		panel_Capture.add(label_30);

		JLabel label_31 = new JLabel("Pin Entry");
		label_31.setBounds(44, 104, 98, 14);
		panel_Capture.add(label_31);

		JLabel label_32 = new JLabel("IPv4 Address");
		label_32.setBounds(44, 129, 98, 14);
		panel_Capture.add(label_32);

		JLabel label_33 = new JLabel("Classification");
		label_33.setBounds(44, 154, 98, 14);
		panel_Capture.add(label_33);

		JLabel label_34 = new JLabel("Card Reader");
		label_34.setBounds(44, 179, 98, 14);
		panel_Capture.add(label_34);

		JLabel label_35 = new JLabel("Balance Enquiry");
		label_35.setBounds(44, 202, 98, 14);
		panel_Capture.add(label_35);

		JLabel label_36 = new JLabel("Host Adjustment");
		label_36.setBounds(44, 227, 98, 14);
		panel_Capture.add(label_36);

		JLabel label_37 = new JLabel("Longitude");
		label_37.setBounds(44, 330, 98, 14);
		panel_Capture.add(label_37);

		JLabel label_38 = new JLabel("Latitude");
		label_38.setBounds(44, 352, 98, 14);
		panel_Capture.add(label_38);

		textField_TerminalID = new JTextField();
		textField_TerminalID.setText("" + globals.getTerminalID());
		textField_TerminalID.setColumns(10);
		textField_TerminalID.setBounds(178, 28, 133, 20);
		panel_Capture.add(textField_TerminalID);

		textField_SequenceNum = new JTextField();
		textField_SequenceNum.setText(globals.getSequenceNumber());
		textField_SequenceNum.setColumns(10);
		textField_SequenceNum.setBounds(178, 53, 133, 20);
		panel_Capture.add(textField_SequenceNum);

		textField_IPv4 = new JTextField();
		textField_IPv4.setText(globals.getiPv4Address());
		textField_IPv4.setColumns(10);
		textField_IPv4.setBounds(178, 129, 133, 20);
		panel_Capture.add(textField_IPv4);

		textField_Longitude = new JTextField();
		textField_Longitude.setText(globals.getLongitude());
		textField_Longitude.setColumns(10);
		textField_Longitude.setBounds(178, 327, 133, 20);
		panel_Capture.add(textField_Longitude);

		textField_Latitude = new JTextField();
		textField_Latitude.setText(globals.getLatitude());
		textField_Latitude.setColumns(10);
		textField_Latitude.setBounds(178, 349, 133, 20);
		panel_Capture.add(textField_Latitude);

		comboBox_EntryMode = new JComboBox();
		comboBox_EntryMode.setBounds(178, 75, 133, 20);
		comboBox_EntryMode.setSelectedItem(globals.getEntryMode());
		comboBox_EntryMode.setModel(new DefaultComboBoxModel(
				new String[] { "unknown", "manual", "track1", "track2",
						"barcode", "ocr", "integrated_circuit",
						"proximity_vsdc", "proximity_contactless" }));
		panel_Capture.add(comboBox_EntryMode);

		comboBox_PinEntry = new JComboBox();
		comboBox_PinEntry.setBounds(178, 101, 133, 20);
		comboBox_PinEntry.setModel(new DefaultComboBoxModel(new String[] {
				"none", "supported", "inoperative", "terminal_verified",
				"unknown" }));
		panel_Capture.add(comboBox_PinEntry);

		comboBox_Classification = new JComboBox();
		comboBox_Classification.setBounds(178, 151, 133, 20);
		comboBox_Classification
				.setModel(new DefaultComboBoxModel(new String[] {
						"unspecified", "limited_amount_terminal",
						"telephone_device", "unattended_atm",
						"unattended_self_service", "electronic_cash_register",
						"mobile_contactless_transaction" }));
		panel_Capture.add(comboBox_Classification);

		comboBox_CardReader = new JComboBox();
		comboBox_CardReader.setBounds(178, 176, 133, 20);
		comboBox_CardReader.setModel(new DefaultComboBoxModel(new String[] {
				"unknown", "magstripe", "barcode", "ocr", "chip", "micr",
				"micr_image", "proximity", "none", "not_specified" }));
		panel_Capture.add(comboBox_CardReader);

		comboBox_BalanceEnquiry = new JComboBox();
		comboBox_BalanceEnquiry.setBounds(178, 199, 133, 20);
		comboBox_BalanceEnquiry.setModel(new DefaultComboBoxModel(new String[] {
				"false", "true" }));
		panel_Capture.add(comboBox_BalanceEnquiry);

		comboBox_HostAdj = new JComboBox();
		comboBox_HostAdj.setBounds(178, 224, 133, 20);
		comboBox_HostAdj.setModel(new DefaultComboBoxModel(new String[] {
				"false", "true" }));
		panel_Capture.add(comboBox_HostAdj);

		JLabel label_39 = new JLabel("Mobile Only");
		label_39.setBounds(153, 305, 68, 14);
		panel_Capture.add(label_39);

		// ****************APPLY VALUES BUTTON*****************//
		JButton button_3 = new JButton("Apply Values");
		button_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyCaptureDeviceValues();
			}
		});
		button_3.setBounds(178, 380, 133, 23);
		panel_Capture.add(button_3);

		/**
		 * Set values for card data
		 */

		// ***************************************************************//

		// ***********************CARD DATA TAB*************************//

		JPanel panel_CardData = new JPanel();
		panel_CardData.setLayout(null);
		tabbedPane.addTab("Card Data", null, panel_CardData, null);

		JLabel label = new JLabel("Card Type");
		label.setBounds(54, 265, 135, 14);
		panel_CardData.add(label);

		JLabel label_1 = new JLabel("Partial Indicator");
		label_1.setBounds(54, 290, 135, 14);
		panel_CardData.add(label_1);

		JLabel label_2 = new JLabel("Card Security Code");
		label_2.setBounds(54, 315, 135, 14);
		panel_CardData.add(label_2);

		JLabel label_3 = new JLabel("Card Holder Name");
		label_3.setBounds(54, 340, 135, 14);
		panel_CardData.add(label_3);

		JLabel label_4 = new JLabel("Gift Card Pin");
		label_4.setBounds(54, 393, 135, 14);
		panel_CardData.add(label_4);

		JLabel label_5 = new JLabel("Gift Card Security Code");
		label_5.setBounds(54, 418, 135, 14);
		panel_CardData.add(label_5);

		JLabel label_6 = new JLabel("Account Type");
		label_6.setBounds(54, 443, 135, 14);
		panel_CardData.add(label_6);

		textField_CardSecCode = new JTextField();
		textField_CardSecCode.setText(globals.getCardSecurityCode());
		textField_CardSecCode.setColumns(10);
		textField_CardSecCode.setBounds(199, 312, 109, 20);
		panel_CardData.add(textField_CardSecCode);

		textField_CardHolderName = new JTextField();
		textField_CardHolderName.setText(globals.getCardHolderName());
		textField_CardHolderName.setColumns(10);
		textField_CardHolderName.setBounds(199, 337, 109, 20);
		panel_CardData.add(textField_CardHolderName);

		textField_GiftCardPin = new JTextField();
		textField_GiftCardPin.setText(globals.getGiftCardPin());
		textField_GiftCardPin.setColumns(10);
		textField_GiftCardPin.setBounds(199, 390, 109, 20);
		panel_CardData.add(textField_GiftCardPin);

		textField_GiftCardSecCode = new JTextField();
		textField_GiftCardSecCode.setText(globals.getGiftCardSecurityCode());
		textField_GiftCardSecCode.setColumns(10);
		textField_GiftCardSecCode.setBounds(199, 415, 109, 20);
		panel_CardData.add(textField_GiftCardSecCode);

		textField_AcctType = new JTextField();
		textField_AcctType.setText(globals.getAccountType());
		textField_AcctType.setColumns(10);
		textField_AcctType.setBounds(199, 440, 109, 20);
		panel_CardData.add(textField_AcctType);

		comboBox_PartialIndicator = new JComboBox();
		comboBox_PartialIndicator.setModel(new DefaultComboBoxModel(
				new String[] { "not_supported", "supported", "return_balance",
						"partial_cash", "full_cash", "partial_merch" }));
		comboBox_PartialIndicator.setBounds(199, 287, 109, 20);
		panel_CardData.add(comboBox_PartialIndicator);

		comboBox_CardType = new JComboBox();
		comboBox_CardType.setModel(new DefaultComboBoxModel(new String[] {
				"visa", "masterCard", "discover", "amex" }));
		comboBox_CardType.setBounds(199, 262, 109, 20);
		panel_CardData.add(comboBox_CardType);

		panel_CardSwiped = new JPanel();
		panel_CardKeyed = new JPanel();

		radioButton_CardSwiped = new JRadioButton("Card Swiped");

		radioButton_CardKeyed = new JRadioButton("Card keyed");
		radioButton_CardKeyed.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (radioButton_CardSwiped.isSelected()) {
					radioButton_CardSwiped.setSelected(false);
					panel_CardSwiped.setVisible(false);
					panel_CardKeyed.setVisible(true);
				}
			}
		});
		radioButton_CardKeyed.setSelected(true);
		radioButton_CardKeyed.setBounds(54, 7, 109, 23);
		panel_CardData.add(radioButton_CardKeyed);

		radioButton_CardSwiped.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (radioButton_CardKeyed.isSelected()) {
					radioButton_CardKeyed.setSelected(false);
					panel_CardKeyed.setVisible(false);
					panel_CardSwiped.setVisible(true);
				}
			}
		});
		radioButton_CardSwiped.setBounds(199, 7, 109, 23);
		radioButton_CardSwiped.setSelected(false);
		panel_CardData.add(radioButton_CardSwiped);

		// card swiped data//

		panel_CardSwiped.setLayout(null);
		panel_CardSwiped.setBounds(54, 151, 315, 71);
		panel_CardData.add(panel_CardSwiped);

		JLabel label_22 = new JLabel("Track 1 Data");
		label_22.setBounds(3, 11, 61, 14);
		panel_CardSwiped.add(label_22);

		textField_Track1 = new JTextField();
		textField_Track1.setText(globals.getTrack1Data());
		textField_Track1.setColumns(10);
		textField_Track1.setBounds(86, 8, 219, 20);
		panel_CardSwiped.add(textField_Track1);

		textField_Track2 = new JTextField();
		textField_Track2.setText(globals.getTrack2Data());
		textField_Track2.setColumns(10);
		textField_Track2.setBounds(86, 33, 219, 20);
		panel_CardSwiped.add(textField_Track2);

		JLabel label_23 = new JLabel("Track 2 Data");
		label_23.setBounds(3, 36, 61, 14);
		panel_CardSwiped.add(label_23);

		// card keyed data//

		panel_CardKeyed.setLayout(null);
		panel_CardKeyed.setBounds(54, 37, 370, 92);
		panel_CardData.add(panel_CardKeyed);

		JLabel label_24 = new JLabel("Primary Account Number");
		label_24.setBounds(10, 14, 125, 14);
		panel_CardKeyed.add(label_24);

		JLabel label_25 = new JLabel("Encrypted PAN");
		label_25.setBounds(10, 39, 125, 14);
		panel_CardKeyed.add(label_25);

		JLabel label_26 = new JLabel("Expiration Date (yyyy-mm)");
		label_26.setBounds(10, 64, 136, 14);
		panel_CardKeyed.add(label_26);

		textField_PAN = new JTextField();
		textField_PAN.setText(globals.getPrimaryAcountNumber());
		textField_PAN.setColumns(10);
		textField_PAN.setBounds(145, 11, 215, 20);
		panel_CardKeyed.add(textField_PAN);

		textField_EncryptedPAN = new JTextField();
		textField_EncryptedPAN.setText(globals.getEncryptedPAN());
		textField_EncryptedPAN.setColumns(10);
		textField_EncryptedPAN.setBounds(145, 36, 215, 20);
		panel_CardKeyed.add(textField_EncryptedPAN);

		textField_ExpirationDate = new JTextField();
		textField_ExpirationDate.setText(globals.getExpirationDate());
		textField_ExpirationDate.setColumns(10);
		textField_ExpirationDate.setBounds(145, 61, 184, 20);
		panel_CardKeyed.add(textField_ExpirationDate);

		JLabel lblNewLabel = new JLabel("Address Line");
		lblNewLabel.setBounds(370, 265, 71, 14);
		panel_CardData.add(lblNewLabel);

		textField_AddressLine = new JTextField();
		textField_AddressLine.setText(globals.getAddressline());
		textField_AddressLine.setColumns(10);
		textField_AddressLine.setBounds(461, 262, 109, 20);
		panel_CardData.add(textField_AddressLine);

		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(370, 290, 71, 14);
		panel_CardData.add(lblCity);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(370, 315, 71, 14);
		panel_CardData.add(lblState);

		JLabel lblZip = new JLabel("Zip");
		lblZip.setBounds(370, 340, 71, 14);
		panel_CardData.add(lblZip);

		textField_City = new JTextField();
		textField_City.setText(globals.getCity());
		textField_City.setColumns(10);
		textField_City.setBounds(461, 287, 109, 20);
		panel_CardData.add(textField_City);

		textField__State = new JTextField();
		textField__State.setText(globals.getState());
		textField__State.setColumns(10);
		textField__State.setBounds(461, 312, 109, 20);
		panel_CardData.add(textField__State);

		textField_PostalCode = new JTextField();
		textField_PostalCode.setText(globals.getPostalCode());
		textField_PostalCode.setColumns(10);
		textField_PostalCode.setBounds(461, 337, 109, 20);
		panel_CardData.add(textField_PostalCode);

		if (!radioButton_CardSwiped.isSelected())
			panel_CardSwiped.setVisible(false);
		if (!radioButton_CardKeyed.isSelected())
			panel_CardKeyed.setVisible(false);

		JButton btnApplyValues = new JButton("Apply Values");
		btnApplyValues.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				applyCardDataValues();
			}
		});
		btnApplyValues.setBounds(199, 477, 184, 23);
		panel_CardData.add(btnApplyValues);

		JLabel lblPinData = new JLabel("Pin Data");
		lblPinData.setBounds(54, 365, 135, 14);
		panel_CardData.add(lblPinData);

		textField_PinData = new JTextField();
		textField_PinData.setText((String) null);
		textField_PinData.setColumns(10);
		textField_PinData.setBounds(199, 362, 109, 20);
		panel_CardData.add(textField_PinData);

		JLabel lblTokenId_1 = new JLabel("Token Id :");
		lblTokenId_1.setBounds(447, 37, 71, 14);
		panel_CardData.add(lblTokenId_1);

		JLabel lblTokenValue_1 = new JLabel("Token Value :");
		lblTokenValue_1.setBounds(447, 62, 71, 14);
		panel_CardData.add(lblTokenValue_1);

		textField_tokenId = new JTextField();
		textField_tokenId.setText((String) null);
		textField_tokenId.setColumns(10);
		textField_tokenId.setBounds(528, 34, 109, 20);
		textField_tokenId.setText(textField_TokenId.getText());
		panel_CardData.add(textField_tokenId);

		textField_tokenValue = new JTextField();
		textField_tokenValue.setText((String) null);
		textField_tokenValue.setColumns(10);
		textField_tokenValue.setBounds(528, 59, 109, 20);
		textField_tokenValue.setText(textField_TokenValue.getText());
		panel_CardData.add(textField_tokenValue);



	}

	public void sendSoap() {

		String pass = passTxt.getText();
		String user = userNameTxt.getText();
		String wsdlLoc = wsdlLocTxt.getText();
		String requestType = (String) comboBox_RequestType.getSelectedItem();
		String endpoint = textField_Endpoint.getText();
		// Create the client
		client.setUser(user);
		client.setPass(pass);
		client.setWsdlLocation(wsdlLoc);
		client.setEndpoint(endpoint);
		// Pass the client and the datastore to the Driver
		driver = new Driver(client, globals);
		if (rdbtnSendToApigee.isSelected())
			driver.setSendToApigee(true);

		// Driver invokes the proper request
		BatchResponseType batchResponse = null;
		TransactionResponseType response = null;

		if (requestType.equals("CloseBatch"))
			batchResponse = driver.batchTransaction("closeBatch");
		else if (requestType.equals("BatchBalance"))
			batchResponse = driver.batchTransaction("batchBalance");
		else
			response = driver.startTransaction(requestType);

		if (response != null) {

			if (response.getDeclineCode() != null) {
				textField_DeclineCode.setText(response.getDeclineCode());
				textField_DeclineMessage.setText(response.getDeclineMessage());

			} else {
				textField_DeclineCode.setText(null);
				textField_DeclineMessage.setText(null);
			}
			if (response.getTransactionStatus() != null) {
				textField_RequestResult.setText(response.getTransactionStatus()
						.value());
				textField_AuthorizationCode.setText(response
						.getAuthorizationCode());
				textField_ReferenceNumber
						.setText(response.getReferenceNumber());
			} else {
				textField_RequestResult.setText(null);
				textField_AuthorizationCode.setText(null);
			}
			if (response.getAddressVerificationResult() != null) {
				txt_AddressVerificationType.setText(response
						.getAddressVerificationResult().getType().value());
				txt_AddressVerificationCode.setText(response
						.getAddressVerificationResult().getCode());
			} else {
				txt_AddressVerificationType.setText(null);
				txt_AddressVerificationCode.setText(null);
			}
			if (response.getCardSecurityCodeResult() != null) {
				txt_CardSecCode.setText(response.getCardSecurityCodeResult()
						.getCode());
				txt_CardSecurityCodeType.setText(response
						.getCardSecurityCodeResult().getType().value());
			} else {
				txt_CardSecCode.setText(null);
				txt_CardSecurityCodeType.setText(null);
			}
			if (response.getPaymentServiceResults() != null) {
				if (globals.getCardType().equals("visa")) {
					textField_TransactionId.setText(response
							.getPaymentServiceResults().getVisaResults()
							.getTransactionId());
					textField_ValidationCode.setText(response
							.getPaymentServiceResults().getVisaResults()
							.getValidationCode());
				} else if (globals.getCardType().equals("masterCard")) {
					try {
						textField_TransactionId.setText(response
								.getPaymentServiceResults()
								.getMasterCardResults().getTransactionId());
						textField_ValidationCode.setText(response
								.getPaymentServiceResults()
								.getMasterCardResults().getValidationCode());
					} catch (NullPointerException e1) {

					}
				} else if (globals.getCardType().equals("amex")) {
					textField_TransactionId.setText(response
							.getPaymentServiceResults()
							.getAmericanExpressResults().getTransactionId());
					textField_ValidationCode.setText(response
							.getPaymentServiceResults()
							.getAmericanExpressResults().getValidationCode());
				}
			}
			if (response.getTokenizationResult() != null) {
				TokenizationResultType tokResult = response
						.getTokenizationResult();
				textField_TokenResult.setText("" + tokResult.isSuccessful());
				textField_TokenId
						.setText(tokResult.getTokenType().getTokenId());
				textField_TokenValue.setText(tokResult.getTokenType()
						.getTokenValue());
			}
		} else if (batchResponse != null) {
			System.out.println("batchresposne");
			textField_RequestResult.setText("null");
		// // Add the standard print stream to system.out/err
		// System.setOut(standardOut);
		// System.setErr(standardErr);
		}
	}

	public void applyTransactionData() {
		String transactionAmt = textField_TransAmt.getText();
		String systemTraceId = textField_SystemTraceID.getText();
		String referenceNumber = textField_ReferenceNum.getText();
		String reportGroup = textField_ReportGrp.getText();
		String transactionType = (String) comboBox_TransType.getSelectedItem();
		String paymentType = (String) comboBox_PaymentType.getSelectedItem();
		String networkResponseCode = textField_NetworkResponseCode.getText();
		String purchaseOrder = textField_PurchaseOrder.getText();
		String settlementAmount = textField_SettlementAmt.getText();
		String tipAmount = textField_TipAmount.getText();
		String convenienceFee = textField_ConvenienceFee.getText();
		String originalAuthCode = textField_OrigAuthorizationCode.getText();
		String cancelType = (String) comboBox_CancelType.getSelectedItem();
		String replacementAmount = textField_ReplacementAmt.getText();
		String reversalReason = (String) comboBox_ReversalReason
				.getSelectedItem();
		String originalRefNum = textField_OriginalReferenceNum.getText();
		String adjustmentAmount = textField_AdjustmentAmount.getText();
		String refundAmount = textField_RefundAmt.getText();
		boolean tokenRequested = rdbtnTokenRequested.isSelected();

		// Make sure the amount fields are in the correct format.
		if (util.verifyCurrencyFormat(transactionAmt)) {
			transactionAmt = transactionAmt.substring(1);
			globals.setTransactionAmount(transactionAmt);
		} else {
			errorMessageDialog("Invalid currency format for Transaction Amount");
		}
		if (util.verifyCurrencyFormat(adjustmentAmount)) {
			adjustmentAmount = adjustmentAmount.substring(1);
			globals.setAdjustedAmount(adjustmentAmount);
		} else {
			errorMessageDialog("Invalid currency format for Adjusted Amount");
		}

		if (util.verifyCurrencyFormat(tipAmount)) {
			tipAmount = tipAmount.substring(1);
			globals.setTipAmount(tipAmount);
		} else {
			errorMessageDialog("Invalid currency format for Tip Amount");
		}
		if (util.verifyCurrencyFormat(settlementAmount)) {
			settlementAmount = settlementAmount.substring(1);
			globals.setSettlementAmount(settlementAmount);
		} else {
			errorMessageDialog("Invalid currency format for Settlement Amount");
		}
		if (util.verifyCurrencyFormat(convenienceFee)) {
			convenienceFee = convenienceFee.substring(1);
			globals.setConvenienceFee(convenienceFee);
		} else {
			errorMessageDialog("Invalid currency format for Convenience Fee Amount");
		}
		if (util.verifyCurrencyFormat(replacementAmount)) {
			replacementAmount = replacementAmount.substring(1);
			globals.setReplacementAmount(replacementAmount);
		} else {
			errorMessageDialog("Invalid currency format for Replacement Amount");
		}
		if (util.verifyCurrencyFormat(refundAmount)) {
			refundAmount = refundAmount.substring(1);
			globals.setRefundAmount(refundAmount);
		} else {
			errorMessageDialog("Invalid currency format for Refund Amount");
		}

		globals.setSystemTraceId(Long.parseLong(systemTraceId));
		globals.setReferenceNumber(referenceNumber);
		globals.setReportGroup(reportGroup);
		globals.setTransactionType(transactionType);
		globals.setPaymentType(paymentType);
		globals.setNetworkResponseCode(networkResponseCode);
		globals.setPurchaseOrder(purchaseOrder);
		globals.setAuthorizationCode(originalAuthCode);
		globals.setCancelTransactionType(cancelType);
		globals.setReversalReason(reversalReason);
		globals.setOriginalRefNum(originalRefNum);
		globals.setRefundAmount(refundAmount);
		globals.setTokenRequested(tokenRequested);
	}

	public void applyMerchantValues() {
		String cashNum = textField_CashierNum.getText();
		String chainCod = textField_ChainCode.getText();
		String clerkNum = textField_ClerkNum.getText();
		String DivNum = textField_DivisionNum.getText();
		String laneNumber = textField_LaneNum.getText();
		String merchId = textField_MerchantID.getText();
		String merchName = textField_MerchantName.getText();
		String storeNumb = textField_StoreNum.getText();
		String netRout = textField_NetworkRouting.getText();
		String captDevice = (String) comboBox_CaptureDevice.getSelectedItem();

		// Make sure cashier number is digits only
		if (!cashNum.isEmpty() && cashNum.matches("\\d*"))
			globals.setCashierNumber(Integer.parseInt(cashNum));
		globals.setChainCode(chainCod);
		// Make sure clerk number is digits only
		if (!clerkNum.isEmpty() && clerkNum.matches("\\d*"))
			globals.setClerkNumber(Integer.parseInt(clerkNum));
		globals.setDivisionNumber(DivNum);
		globals.setLaneNumber(laneNumber);
		globals.setMerchantId(merchId);
		globals.setMerchantName(merchName);
		globals.setStoreNumber(storeNumb);
		globals.setNetworkRouting(netRout);
		globals.setCaptureDevice(captDevice);
	}

	public void applyCaptureDeviceValues() {
		String terminalId = textField_TerminalID.getText();
		String sequenceNum = textField_SequenceNum.getText();
		String ip4 = textField_IPv4.getText();
		String longitude = textField_Longitude.getText();
		String latitude = textField_Latitude.getText();
		String entryMode = (String) comboBox_EntryMode.getSelectedItem();
		String pinEntry = (String) comboBox_PinEntry.getSelectedItem();
		String classification = (String) comboBox_Classification
				.getSelectedItem();
		String cardReader = (String) comboBox_CardReader.getSelectedItem();
		String balanceEnquiry = (String) comboBox_BalanceEnquiry
				.getSelectedItem();
		String hostAdjustment = (String) comboBox_HostAdj.getSelectedItem();
		// digits only
		if (terminalId.matches("\\d*"))
			globals.setTerminalID(Integer.parseInt(terminalId));
		// digits only
		if (sequenceNum.matches("\\d*"))
			globals.setSequenceNumber(sequenceNum);
		// regex for an the correct format of an IP4 address
		if (ip4.matches("^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])"))
			globals.setiPv4Address(ip4);
		// digits only
		if (longitude.matches("\\d*"))
			globals.setLongitude(longitude);
		// digits only
		if (latitude.matches("\\d*"))
			globals.setLatitude(latitude);
		globals.setEntryMode(entryMode);
		globals.setPinEntry(pinEntry);
		globals.setClassification(classification);
		globals.setCardReader(cardReader);
		globals.setBalanceEnquiry(Boolean.parseBoolean(balanceEnquiry));
		globals.setHostAdjustment(Boolean.parseBoolean(hostAdjustment));
	}

	public void applyCardDataValues() {
		String cardSecCode = textField_CardSecCode.getText();
		String cardHolderName = textField_CardHolderName.getText();
		String giftCardPin = textField_GiftCardPin.getText();
		String giftCardSecCode = textField_GiftCardSecCode.getText();
		String accountType = textField_AcctType.getText();
		String partialIndicator = (String) comboBox_PartialIndicator
				.getSelectedItem();
		String cardType = (String) comboBox_CardType.getSelectedItem();
		Boolean cardKeyed = radioButton_CardKeyed.isSelected();
		Boolean cardSwiped = radioButton_CardSwiped.isSelected();
		String primaryAcctNum = textField_PAN.getText().trim();

		String encryptedPAN = textField_EncryptedPAN.getText();
		String expirationDate = textField_ExpirationDate.getText();
		String track1 = textField_Track1.getText();
		String track2 = textField_Track2.getText();
		// Address
		String addressLine = textField_AddressLine.getText();
		String city = textField_City.getText();
		String state = textField__State.getText();
		String postalCode = textField_PostalCode.getText();
		String pinData = textField_PinData.getText();

		String tokenId = textField_tokenId.getText();
		String tokenValue = textField_tokenValue.getText();

		if (cardKeyed) {
			globals.setCardKeyed(true);
			globals.setCardSwiped(false);
			globals.setPrimaryAcountNumber(primaryAcctNum);
			globals.setExpirationDate(expirationDate);
			if (!tokenId.isEmpty() && !tokenValue.isEmpty()) {
				globals.setTokenId(tokenId);
				globals.setTokenValue(tokenValue);
				globals.setCardToken(true);
			} else
				globals.setCardToken(false);
			String verifyCardNum = util.verifyCardNumberFormat(primaryAcctNum);
			if (verifyCardNum == null) {
				errorMessageDialog("Invalid Primary Account Number format");
			} else {
				if (!verifyCardNum.isEmpty())
					comboBox_CardType.setSelectedItem(verifyCardNum);
			}

		} else {
			globals.setCardSwiped(true);
			globals.setCardKeyed(false);
			globals.setTrack1Data(track1);
			globals.setTrack2Data(track2);
		}

		globals.setCardSecurityCode(cardSecCode);
		globals.setCardHolderName(cardHolderName);
		globals.setGiftCardPin(giftCardPin);
		globals.setGiftCardSecurityCode(giftCardSecCode);
		globals.setAccountType(accountType);
		globals.setPartialIndicator(partialIndicator);
		globals.setCardType(cardType);
		globals.setAddressline(addressLine);
		globals.setCity(city);
		globals.setState(state);
		globals.setPostalCode(postalCode);
		globals.setPinData(pinData);

	}

	public void errorMessageDialog(String msg) {
		JOptionPane.showMessageDialog(this, msg);
	}
}
